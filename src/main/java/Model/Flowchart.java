package Model;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Stack;

/**
 * Represents a control flow chart as a graph of shapes, with the control flow connections as edges
 * */
public class Flowchart {
	private final ArrayList<Vertex<Shape>> vertices;
	private final ArrayList<Edge<Shape>> edges;
	
	/**
	 * Stores the result of diff. See details in DiffSummary enum
	 * */
	public static class DiffResult {
		DiffSummary summary;
		ShapeType specificType;
		ShapeType specificTypeFrom, specificTypeTo;
		
		public DiffResult(DiffSummary summary) {
			this.summary = summary;
		}
		
		public DiffResult(DiffSummary summary, ShapeType type) {
			this.summary = summary;
			this.specificType = type;
		}
		
		public DiffResult(DiffSummary summary, ShapeType fromType, ShapeType toType) {
			this.summary = summary;
			this.specificTypeFrom = fromType;
			this.specificTypeTo = toType;
		}
	}
	/**
	 * A summary of the results of the diff
	 * Key:
	 * NONE - No difference detected
	 * NOT_ENOUGH_ELEMENTS - The other flowchart does not have enough elements
	 * TOO_MANY_ELEMENTS - The other flowchart has too many elements
	 * NOT_ENOUGH_SPECIFIC - The other flowchart does not have enough of a specific shape, specified in DiffResult.specificType
	 * TOO_MANY_SPECIFIC - The other flowchart has too many of a specific shape, specified in DiffResult.specificType
	 * TOO_MANY_EDGES - The other flowchart has too many connections
	 * NOT_ENOUGH_EDGES - The other flowchart doesn't have enough connections
	 * TOO_MANY_EDGES_SPECIFIC - The other flowchart has too many connections from one shape type to another, specified in DiffResult.specificTypeFrom and DiffResult.specificTypeTo
	 * NOT_ENOUGH_EDGES_SPECIFIC - The other flowchart doesn't have enough connections from one shape type to another, specified in DiffResult.specificTypeFrom and DiffResult.specificTypeTo
	 * */
	public enum DiffSummary {
		NONE,
		NOT_ENOUGH_ELEMENTS, TOO_MANY_ELEMENTS,
		NOT_ENOUGH_SPECIFIC, TOO_MANY_SPECIFIC,
		TOO_MANY_EDGES, NOT_ENOUGH_EDGES,
		TOO_MANY_EDGES_SPECIFIC, NOT_ENOUGH_EDGES_SPECIFIC
	}
	
	public Flowchart(Stack<Shape> shapeStack) {
		vertices = new ArrayList<>();
		edges = new ArrayList<>();

		//Add shapes
		for (Shape shape : shapeStack) {
			vertices.add(new Vertex<>(shape));
		}
		
		//Add edges
		for(Shape shape : shapeStack) {
			//Find shape in vertices
			Vertex<Shape> fromVertex = null;
			for(Vertex<Shape> vertex : vertices) {
				if(vertex.get().equals(shape)) {
					fromVertex = vertex;
				}
			}
			
			if(fromVertex == null) {
				System.err.println("Could not find shape while creating edges");
			}
			
			//Add out arrows/edges
			for(Arrow arrow : shape.getOutArrows()) {
				edges.add(new Edge<Shape>(new Vertex<Shape>(arrow.getOutShape()), new Vertex<Shape>(arrow.getInShape())));
				/*
				//Find the shape it goes to
				for(Vertex<Shape> toVertex : vertices) {
					if(toVertex.get().equals(arrow.getOutShape())) {
						edges.add(new Edge<>(fromVertex, toVertex));
					}
				}*/
			}
		}
	}
	
	private static class Vertex<T> {
		private final T value;
		public Vertex(T t) {
			this.value = t;
		}
		
		public T get() {
			return value;
		}
		
		@Override
		public String toString() {
			return "Vertex{" +
					"value=" + value +
					'}';
		}
	}

	private static class Edge<T> {
		private final Vertex<T> from;
		private final Vertex<T> to;
		public Edge(Vertex<T> from, Vertex<T> to) {
			this.from = from;
			this.to = to;
		}
		
		@Override
		public String toString() {
			return "Edge{" +
					"from=" + from.toString() +
					", to=" + to.toString() +
					'}';
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Flowchart other = (Flowchart) o;
		
		return diff(other).summary.equals(DiffSummary.NONE);
	}
	
	/**
	 * Compares two flowcharts and returns a DiffResult
	 * 	The DiffResult has a DiffSummary, which shows the result of the test, and an optional ShapeType
	 * 	which gives more detail in specific cases
	 * */
	public DiffResult diff(Flowchart other) {
		//Check number of elements
		if(vertices.size() < other.vertices.size()) {
			return new DiffResult(DiffSummary.TOO_MANY_ELEMENTS);
		} else if (vertices.size() > other.vertices.size()) {
			return new DiffResult(DiffSummary.NOT_ENOUGH_ELEMENTS);
		}
		
		//Check they have the right number of each type of shape
		for(ShapeType type : ShapeType.values()) {
			int correctNum = 0;
			int otherNum = 0;
			//Count number of type in this flowchart
			for(Vertex<Shape> v : vertices) {
				if(v.get().getShapeType().equals(type)) {
					correctNum++;
				}
			}
			
			//Count number of type in other flowchart
			for(Vertex<Shape> v : other.vertices) {
				if(v.get().getShapeType().equals(type)) {
					otherNum++;
				}
			}
			
			//Compare
			if(correctNum < otherNum) {
				return new DiffResult(DiffSummary.NOT_ENOUGH_SPECIFIC, type);
			} else if (correctNum > otherNum) {
				return new DiffResult(DiffSummary.TOO_MANY_SPECIFIC, type);
			}
		}
		
		// Check number of edges
		if(edges.size() < other.edges.size()) {
			return new DiffResult(DiffSummary.TOO_MANY_EDGES);
		} else if (edges.size() > other.edges.size()) {
			return new DiffResult(DiffSummary.NOT_ENOUGH_EDGES);
		}
		
		// For each combination of two shape types, make sure they have the right amount of edges from the first to
		// second shape - this isn't a perfect comparison, but should work for most cases
		for(ShapeType fromType : ShapeType.values()) {
			for (ShapeType toType : ShapeType.values()) {
				int correctNum = 0;
				int otherNum = 0;
				
				// Find number of edges in this graph that go from fromType to toType
				for(Edge<Shape> e : edges) {
					if(e.from.get().getShapeType().equals(fromType) && e.to.get().getShapeType().equals(toType)) {
						correctNum++;
					}
				}
				
				// Find number of edges in the other graph that go from fromType to toType
				for(Edge<Shape> e : other.edges) {
					if(e.from.get().getShapeType().equals(fromType) && e.to.get().getShapeType().equals(toType)) {
						otherNum++;
					}
				}
				
				// Compare
				if(correctNum < otherNum) {
					return new DiffResult(DiffSummary.TOO_MANY_EDGES_SPECIFIC, fromType, toType);
				} else if (correctNum > otherNum) {
					return new DiffResult(DiffSummary.NOT_ENOUGH_EDGES_SPECIFIC, fromType, toType);
				}
			}
		}
		
		return new DiffResult(DiffSummary.NONE);
	}
}

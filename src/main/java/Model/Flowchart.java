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
		ShapeType type;
		
		public DiffResult(DiffSummary summary, Optional<ShapeType> optType) {
			this.summary = summary;
			optType.ifPresent(shapeType -> this.type = shapeType);
		}
	}
	/**
	 * A summary of the results of the diff
	 * Key:
	 * NONE - No difference detected
	 * NOT_ENOUGH_ELEMENTS - The other flowchart does not have enough elements
	 * TOO_MANY_ELEMENTS - The other flowchart has too many elements
	 * NOT_ENOUGH_SPECIFIC - The other flowchart does not have enough of a specific shape, specified in DiffResult.type
	 * TOO_MANY_SPECIFIC - The other flowchart has too many of a specific shape, specified in DiffResult.type
	 * */
	public enum DiffSummary {
		NONE,
		NOT_ENOUGH_ELEMENTS, TOO_MANY_ELEMENTS,
		NOT_ENOUGH_SPECIFIC, TOO_MANY_SPECIFIC
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
				//Find the shape it goes to
				for(Vertex<Shape> toVertex : vertices) {
					if(toVertex.get().equals(arrow.getOutShape())) {
						edges.add(new Edge<>(fromVertex, toVertex));
					}
				}
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
			return new DiffResult(DiffSummary.TOO_MANY_ELEMENTS, Optional.empty());
		} else if (vertices.size() > other.vertices.size()) {
			return new DiffResult(DiffSummary.NOT_ENOUGH_ELEMENTS, Optional.empty());
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
				return new DiffResult(DiffSummary.NOT_ENOUGH_SPECIFIC, Optional.of(type));
			} else if (correctNum > otherNum) {
				return new DiffResult(DiffSummary.TOO_MANY_SPECIFIC, Optional.of(type));
			}
		}
		
		//TODO check edges
		
		return new DiffResult(DiffSummary.NONE, Optional.empty());
	}
}

package serialization;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.IOException;
import java.io.Serializable;

public class MySerializableStrokeAdapter implements Stroke, Serializable {
	private static final long serialVersionUID = 1L;

	private Stroke stroke;
	
	public MySerializableStrokeAdapter(Stroke stroke) {
		this.stroke = stroke;
	}
	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		if (stroke instanceof BasicStroke) {
			BasicStroke s = (BasicStroke) stroke;
			out.writeFloat(s.getLineWidth());
			out.writeInt(s.getEndCap());
			out.writeInt(s.getLineJoin());
			out.writeFloat(s.getMiterLimit());
			out.writeObject(s.getDashArray());
			out.writeFloat(s.getDashPhase());
		}
	}
	
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		stroke = new BasicStroke(in.readFloat(), in.readInt(), in.readInt(),
    				in.readFloat(), (float[]) in.readObject(), in.readFloat()
    	);
	}
	
	@Override
	public Shape createStrokedShape(Shape shape) {
		return stroke.createStrokedShape(shape);
	}

}

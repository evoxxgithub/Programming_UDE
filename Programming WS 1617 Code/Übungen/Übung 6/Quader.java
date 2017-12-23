
public class Quader {
	int height, width, depth;
	
	Quader(int height, int width, int depth) {
		this.height = height;
		this.width = width;
		this.depth = depth;
	}
	int volume(Quader q) {	
		return q.width * q.depth * q.height;
	}
	int surfacearea(Quader q) {
		return 2*(q.width * q.height + q.width * q.depth + q.height*q.depth);
	}
}
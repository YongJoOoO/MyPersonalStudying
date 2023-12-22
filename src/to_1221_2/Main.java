package to_1221_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * 객체는 매번 생성할 때 다른 해시코드를 갖고 다른 주소값을 갖는 다른 객체로 분류된다.
 * 그런데 만약 객체의 필드가 같을 떄 동일한 객체로 처리하고 싶음녀 어떻게 해야 할까 ?
 * 
 * equals 와 hashCode()를 해당 클래스에서 재정의해서 사용하면 된다. !
 * @author MYLG
 *
 */
class Point{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Point) {
			Point o = (Point)obj;
			return this.x == o.x && this.y == o.y;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(x, y);
		/**
		 * 클래스가 여러 가지 필드를 가지고 있을 때 필드들로부터 해시코드를 생성하면
			동일한 필드값을 가지는 객체는 동일한 해시코드를 가질 수 있습니다. 
		 */
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Point, Integer> map = new HashMap<>();
		
		map.put(new Point(1, 0), map.getOrDefault(new Point(1, 0), 0) + 1);
		map.put(new Point(1, 0), map.getOrDefault(new Point(1, 0), 0) + 1);
		map.put(new Point(1, 0), map.getOrDefault(new Point(1, 0), 0) + 1);
		map.put(new Point(1, 0), map.getOrDefault(new Point(1, 0), 0) + 1);
		map.put(new Point(1, 0), map.getOrDefault(new Point(1, 0), 0) + 1);
		map.put(new Point(1, 0), map.getOrDefault(new Point(1, 0), 0) + 1);
		map.put(new Point(1, 0), map.getOrDefault(new Point(1, 0), 0) + 1);
		map.put(new Point(1, 0), map.getOrDefault(new Point(1, 0), 0) + 1);
		
		System.out.println("map에 담긴 key의 개수 :  " + map.size()+ " ");
		
		for(Point key : map.keySet()) {
			System.out.println();
			System.out.println(key +"의 개수 :  " + map.get(key) + "개 ");
		}
	}

}

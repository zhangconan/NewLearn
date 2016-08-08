import java.util.List;

public class GetSet {

	/**
	 * 订单状态的集合
	 */
	private List<Integer> eventStatusList;
    /**
     * 演讲人ID集合
     */
    private List<Long> speakerIds; 
	public List<Integer> getEventStatusList() {
		return eventStatusList;
	}

	public void setEventStatusList(List<Integer> eventStatusList) {
		this.eventStatusList = eventStatusList;
	}
	
	public static void main(String[] args) {
		Integer val1 = 199;
		Integer val2 = 344;
		if(val1 < val2){
			System.out.println("张三李四");
		}else{
			System.out.println("sdsdsdsd");
		}

		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program" + "ming";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s1.intern());
	}
}

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
		String[] str = "26;27".split(";");
		System.out.println(str.length);
	}
}

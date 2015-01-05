
public class tess {

	public static void main(String[] args) throws Exception  {
		new tess().testname();
	} 
	
	//return结束整个方法
	// break  退出当期那的for
	public void testname() {
		
		
		for(int i=0;i<3;i++){
			for(int k=0;k<2;k++){
				System.out.println(k);
				if(k==0){
					//return;
					break;
				}
			}
		}
		System.out.println(11111111);
	}
}

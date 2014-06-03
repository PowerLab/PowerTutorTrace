
package cnu.eslab.fileTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.lowagie.text.pdf.ArabicLigaturizer;

public class FileStream {
	public static final int TOTAL_POWER = 0;
	public static final int BATTERY_CAPACITY = 1;
	public static final int CPU_POWER = 2;
	public static final int WIFI_POWER = 3;
	public static final int THREEG_POWER = 10;
	public static final int GPS_POWER = 4;
	public static final int AUDIO_POWER = 5;
	public static final int LED_POWER = 6;
	public static final int TOTAL_LED_POWER = 7;
	public static final int TOTAL_CPU_POWER = 8;
	public static final int TOTAL_WIFI_POWER = 9;
	public static final int TOTAL_THREEG_POWER = 11;
	static final int UNIT = 60;
	static public ArrayList<Integer>	cpuList = new ArrayList<Integer>();
	private String mFileName;
	
	public void setFileName(String arFileName){
		mFileName = arFileName;
	}

	
	//UID를 LOG 파일에서 읽어오는 메소드 이다.
	public ArrayList<String> ParsingUID() throws FileNotFoundException{
		ArrayList<String> sUID = new ArrayList<String>();
		Scanner mainScanner =null;
		String line;
		int IndexFirst = -1;
		
		if(mFileName == null) return null;
		else{
			mainScanner = new Scanner(new BufferedReader(new FileReader(mFileName)));
			mainScanner.useDelimiter("\n");				
			//파일에 끝에 도달할 때 까지 반복을 해준다.
			while(mainScanner.hasNext()){
				line = mainScanner.next();
				//현재 라인에 associate가 존재한다면
				IndexFirst = line.indexOf("associate");
				if(IndexFirst >= 0){
					//적용된 UID를 추출해 오기위해 공백을 기준으로 추출한다.
					IndexFirst = line.indexOf(" ", IndexFirst);
					sUID.add(line.substring(IndexFirst+1));
					//System.out.println(line.substring(IndexFirst+1));
				}
			}
			return sUID;
		}
	}
	//시간 단위로 Parsing하는 함수이다.
	public ArrayList<String> ParsingTime() throws FileNotFoundException{
		ArrayList<String> sTime = new ArrayList<String>();
		Scanner mainScanner = null;
		String line;
		int IndexFirst = -1;
		
		//파일이 설절되지 않았을 때는 작업을 할 수 없기 때문에 null을 반환 한다.
		if(mFileName == null) return null;
		else{
			mainScanner = new Scanner(new BufferedReader(new FileReader(mFileName)));
			//total-power만큼 끈어 준다. 이유는 total-power가 측정되어지는 구간을 1초라고 보기  떄문이다.
			mainScanner.useDelimiter("CurrentTime ");	
			//첫번째 단락은 각종 초기 옵션값이랑 현 상태의 UID 정보이므로 SKIP 한다.
			line = mainScanner.next();
			
			//파일에 끝에 도달할 때 까지 반복을 해준다.
			while(mainScanner.hasNext()){
				line = mainScanner.next();
				IndexFirst = line.indexOf("\n"); // 첫번째 줄바꿈의 인덱스를 찾아온다
				// 맨처음부터 첫번째 줄바꿈까지가 total power의 값이다. 그것을 ArrayList에 대입해 준다.
				sTime.add(line.substring(0, IndexFirst));
			}

			
		}
		return sTime;
	}
	// Total Power Consumption을 LOG 파일에서 UID에 따라 추출하는 함수 이다.
	public ArrayList<Integer> ParsingPowerConsumption(String arUID, int Mode) throws FileNotFoundException{
		ArrayList<Integer> sPower = new ArrayList<Integer>();
		Scanner mainScanner = null;
		String line;
		int powerCap=0;
		int IndexFirst = -1;
		
		//파일이 설정되지 않았을 때는 작업을 할 수 없기 떄문에  null을 반환 한다.
		if(mFileName == null) return null;
		else{

			mainScanner = new Scanner(new BufferedReader(new FileReader(mFileName)));
			//total-power만큼 끈어 준다. 이유는 total-power가 측정되어지는 구간을 1초라고 보기  떄문이다.
			mainScanner.useDelimiter("total-power ");	
			
			//첫번째 단락은 각종 초기 옵션값이랑 현 상태의 UID 정보이므로 SKIP 한다.
			line = mainScanner.next();
			
			//파일에 끝에 도달할 때 까지 반복을 해준다.
			while(mainScanner.hasNext()){
				line = mainScanner.next();	// total power로 구분되어진 문자열을 저장한다.
				
				//각 모드에 따라서 다르게 동작 해줘야 정확한 값을 ArrayList에 담을 수 있다.
				if(Mode == TOTAL_POWER){
					IndexFirst = line.indexOf("\n"); // 첫번째 줄바꿈의 인덱스를 찾아온다
					
					// 맨처음부터 첫번째 줄바꿈까지가 total power의 값이다. 그것을 ArrayList에 대입해 준다.
					sPower.add(Integer.parseInt(line.substring(0, IndexFirst)));
				}
				else if(Mode == BATTERY_CAPACITY){
					if(PowerParser(line,String.format("battery-change 0"),1) !=0){
						powerCap = PowerParser(line,String.format("battery-change 0"),1);
						sPower.add(powerCap);
					}
					else{
						sPower.add(powerCap);
					}
				}
				else if(Mode == CPU_POWER){
					sPower.add(PowerParser(line,String.format("CPU-"+arUID),0));	
				}
				else if(Mode == WIFI_POWER){
					sPower.add(PowerParser(line,String.format("Wifi-"+arUID),0));
				}
				else if(Mode == THREEG_POWER){
					sPower.add(PowerParser(line, String.format("3G-"+arUID), 0));
				}
				else if(Mode == GPS_POWER){
					sPower.add(PowerParser(line,String.format("GPS "),0));
				}
				else if(Mode == AUDIO_POWER){
					sPower.add(PowerParser(line,String.format("Audio "),0));
				}
				else if(Mode == LED_POWER){
					sPower.add(PowerParser(line,String.format("OLED-"+arUID),0));
				}
				else if(Mode == TOTAL_CPU_POWER){
					sPower.add(PowerParser(line,String.format("CPU "),0));
				}
				else if(Mode == TOTAL_LED_POWER){
					sPower.add(PowerParser(line,String.format("OLED "),0));
				}
				else if(Mode == TOTAL_WIFI_POWER){
					sPower.add(PowerParser(line,String.format("Wifi "),0));
				}
				else if(Mode == TOTAL_THREEG_POWER){
					sPower.add(PowerParser(line,String.format("3G "),0));
				}
			}
			return sPower;
		}
	}
	
	public static int PowerParser(String line, String patten, int mode){
		int IndexFirst = -1;
		int IndexEnd = -1;

		IndexFirst = line.indexOf(patten);
		//mode = 0 일반적은 Power 값을 얻어오는 부분이다. 음수값이 나오면 해당 string에 값이 없다는 뜻이다.
		//indexOf 함수의 뜻은 뒤에 from에서부터 시작해서 검색하라는 뜻이다.
		if( IndexFirst >= 0 && mode == 0){
			IndexFirst = line.indexOf(" ", IndexFirst);
			IndexEnd = line.indexOf("\n", IndexFirst);
			int temp; //debug
			try{
				temp =  Integer.parseInt(line.substring(IndexFirst+1, IndexEnd));	
			}catch (Exception e) {
				// TODO: handle exception
				temp = 0;
			}
			
			return temp;
		}
		//mode = 1 총 소모 Power 값을 얻어오는 부부분이다.
		else if(IndexFirst >= 0 && mode == 1){
			IndexFirst = line.indexOf(" ", IndexFirst);
			IndexFirst = line.indexOf(" ", IndexFirst+1);
			IndexEnd = line.indexOf("/", IndexFirst);
			return Integer.parseInt(line.substring(IndexFirst+1, IndexEnd));
		}
		else{//없다면 시간값을 맞춰 주기위해서 소비값 0을 입력하여 준다.
			return 0;
		}
	}
}

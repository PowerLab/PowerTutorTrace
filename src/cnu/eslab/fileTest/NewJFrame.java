package cnu.eslab.fileTest;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class NewJFrame extends javax.swing.JFrame implements ActionListener,
		ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int POWER_BUTTON_OFF = 0;
	public static final int POWER_BUTTON_ON = 1;

	public static final int TOTAL_POWER = 0;
	public static final int BATTERY_CAPACITY = 1;
	public static final int CPU_POWER = 2;
	public static final int WIFI_POWER = 3;
	public static final int GPS_POWER = 4;
	public static final int AUDIO_POWER = 5;
	public static final int LED_POWER = 6;
	public static final int THREEG_POWER = 10;

	public static final int TOTAL_LED_POWER = 7;
	public static final int TOTAL_CPU_POWER = 8;
	public static final int TOTAL_WIFI_POWER = 9;
	public static final int TOTAL_THREEG_POWER = 11;
	private JButton mTotalCompareBtn;
	private JButton mCompareAppPowerBtn;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JButton mDeleteUidMoveBtn;
	private JButton mDeleteOneBtn;
	private JButton mDeleteAllBtn;
	private JList mDeleteList;
	private JScrollPane jScrollPane2;
	private JButton mComponentPieBtn;

	public static boolean FLAG_GPS_STATE = false;
	public static boolean FLAG_AUDIO_STATE = false;

	private JFileChooser mJFileChooser;
	private File mFileName;

	private ArrayList<String> mUidArrayList;
	private ArrayList<Integer> mTotalPowerArrayList;
	private ArrayList<String> mTimeArrayList;
	private ArrayList<Integer> mBatteryCapacityArrayList;
	private ArrayList<Integer> mCpuPowerArrayList;
	private JButton mAppTotalPowerBtn;
	private ArrayList<Integer> mWifiPowerArrayList;
	private ArrayList<Integer> mThreeGPowerArrayList;
	private JButton mPhoneTotalStackPowerBtn;
	private JButton mComponentLEDBtn;
	private JButton mComponentCPUBtn;
	private JButton mComponentWIFIBtn;
	private JButton mComponentThreeGBtn;
	private JLabel jLabel5;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel jPanel7;
	private JPanel jPanel4;
	private ArrayList<Integer> mGpsPowerArrayList;
	private ArrayList<Integer> mLedPowerArrayList;
	private ArrayList<Integer> mAudioPowerArrayList;
	private ArrayList<Integer> mComponentWifiArrayList;

	private DefaultListModel listModel;
	private DefaultListModel listModelUidDelte;

	// 범위지정 변수이다.
	private int mFirstRange;
	private int mSecondRange;

	// 파일처리를 위해 파일을 처리하는 객체를 소유하고 있는다.
	private FileStream mCFileStream;

	// 검색할 UI를 설정 한다.
	private String mSearchUid;
	private String mSerarchUidOld;

	private JPanel jPanel1;
	private JButton mParsingBtn;
	private JButton mFileBtn;
	private JButton m3GBtn;
	private JCheckBox mGPSCheckBox;
	private JCheckBox mAudioCheckBox;
	private JButton mDevicesPowerButton;
	private JButton mAppStackedPower;
	private JTextField mChartMeanUnitTextField;
	private JButton m3DBarChartMean;
	private JLabel jLabel4;
	private JPanel jPanel6;
	private JTextField mSecondRangeText;
	private JLabel jLabel3;
	private JButton mUidPieDiagramBtn;
	private JTextField mFirstRangeText;
	private JLabel Range;
	private JPanel jPanel5;
	private JTextField mLogScaleTextFiled;
	private JLabel LOGTimeLabel;
	private JScrollPane jScrollPane1;
	private JButton mAudioBtn;
	private JButton mGpsBtn;
	private JList mUidList;
	private JLabel dd;
	private JPanel jPanel3;
	private JTextField mFilePathTextField;
	private JLabel mFilePathLabel;
	private JPanel jPanel2;
	private JButton mLedBtn;
	private JButton mWifiBtn;
	private JButton mCpuBtn;
	private JButton mBatteryCapacityBtn;
	private JButton mTotalPowerBtn;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public File getFileName() {
		return mFileName;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		NewJFrame aa = new NewJFrame();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});

	}

	public NewJFrame() {
		super();
		initGUI();
		Myinit();
	}

	private void Myinit() {
		// ArrayList를 생성한다.
		mUidArrayList = new ArrayList<String>();
		// 파일 처리를 하는 객체를 생성 한다.
		mCFileStream = new FileStream();

		mJFileChooser = new JFileChooser(); // 파일 선택기를 생성 한다.
		mFileBtn.addActionListener(this); // 리스너를 등록 한다.
		mParsingBtn.addActionListener(this);
		mTotalPowerBtn.addActionListener(this);
		mBatteryCapacityBtn.addActionListener(this);
		mCpuBtn.addActionListener(this);
		mWifiBtn.addActionListener(this);
		mLedBtn.addActionListener(this);
		mGpsBtn.addActionListener(this);
		mAudioBtn.addActionListener(this);
		mUidPieDiagramBtn.addActionListener(this);
		m3DBarChartMean.addActionListener(this);
		mDevicesPowerButton.addActionListener(this);

		mAppTotalPowerBtn.addActionListener(this);
		mAppStackedPower.addActionListener(this);
		mUidList.addListSelectionListener(this);

		mGPSCheckBox.addActionListener(this);
		mAudioCheckBox.addActionListener(this);
		m3GBtn.addActionListener(this);
		
		//component별 출력을 담당하는 버튼에 리스너를 단다.
		mComponentLEDBtn.addActionListener(this);
		mComponentCPUBtn.addActionListener(this);
		mComponentWIFIBtn.addActionListener(this);
		mComponentThreeGBtn.addActionListener(this);
		mPhoneTotalStackPowerBtn.addActionListener(this);
		mComponentPieBtn.addActionListener(this);
		mDeleteUidMoveBtn.addActionListener(this); // 리스트에 삭제할것을 저장하는 버튼
		mDeleteOneBtn.addActionListener(this);	// 삭제 리스트에서 선택한 UID 삭제
		mDeleteAllBtn.addActionListener(this);	// 삭제 리스트에서 모든 UID 삭제
		mCompareAppPowerBtn.addActionListener(this);
		mTotalCompareBtn.addActionListener(this);	// 총 파워 소비 평균을 계산한것을 비교 하기위한 그래프 이다.
		
		// 오작동 방지를 위해서 일단 그래프관련 버튼을 OFF 시킨다.
		ComponetStateChanger(POWER_BUTTON_OFF);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanel1 = new JPanel();
				FlowLayout jPanel1Layout = new FlowLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, "North");
				jPanel1.setBounds(12, 434, 590, 66);
				jPanel1.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
				{
					mParsingBtn = new JButton();
					jPanel1.add(mParsingBtn);
					mParsingBtn.setText("Parsing");
					mParsingBtn
							.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mTotalPowerBtn = new JButton();
					jPanel1.add(mTotalPowerBtn);
					mTotalPowerBtn.setText("Phone Total Power");
					mTotalPowerBtn.setPreferredSize(new java.awt.Dimension(140,
							24));
				}
				{
					mBatteryCapacityBtn = new JButton();
					jPanel1.add(mBatteryCapacityBtn);
					mBatteryCapacityBtn.setText("Battery Capacity");
					mBatteryCapacityBtn
							.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mTotalCompareBtn = new JButton();
					jPanel1.add(mTotalCompareBtn);
					mTotalCompareBtn.setText("Total Compare");
					mTotalCompareBtn.setPreferredSize(new java.awt.Dimension(124, 24));
				}
				{
					mPhoneTotalStackPowerBtn = new JButton();
					jPanel1.add(mPhoneTotalStackPowerBtn);
					mPhoneTotalStackPowerBtn.setText("Phone Total Stack Power");
				}
				{
					mDevicesPowerButton = new JButton();
					jPanel1.add(mDevicesPowerButton);
					mDevicesPowerButton.setText("Hardware Component Max Power");
					mDevicesPowerButton.setPreferredSize(new java.awt.Dimension(280, 24));
				}
				{
					mCompareAppPowerBtn = new JButton();
					jPanel1.add(mCompareAppPowerBtn);
					mCompareAppPowerBtn.setText("Compare");
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2, "West");
				jPanel2.setBounds(12, 25, 589, 67);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
				{
					mFilePathLabel = new JLabel();
					jPanel2.add(mFilePathLabel);
					mFilePathLabel.setText("File Path");
					mFilePathLabel.setPreferredSize(new java.awt.Dimension(48,
							17));
					mFilePathLabel.setBounds(8, 8, 48, 17);
				}
				{
					mFilePathTextField = new JTextField();
					jPanel2.add(mFilePathTextField);
					mFilePathTextField.setText("None");
					mFilePathTextField.setEditable(false);
					mFilePathTextField.setBounds(68, 4, 430, 24);
				}
				{
					mFileBtn = new JButton();
					jPanel2.add(mFileBtn);
					mFileBtn.setText("OPEN");
					mFileBtn.setBounds(503, 6, 81, 24);
				}
				{
					LOGTimeLabel = new JLabel();
					jPanel2.add(LOGTimeLabel);
					LOGTimeLabel.setText("LOG Time");
					LOGTimeLabel.setBounds(8, 37, 60, 17);
				}
				{
					mLogScaleTextFiled = new JTextField();
					jPanel2.add(mLogScaleTextFiled);
					mLogScaleTextFiled.setText("None");
					mLogScaleTextFiled.setEditable(false);
					mLogScaleTextFiled.setBounds(68, 34, 430, 24);
				}
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(13, 122, 424, 228);
				{
					listModel = new DefaultListModel();// List의 데이터를 관리하는 모델이다.
					mUidList = new JList(listModel);
					mUidList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 하나만
					// 선택
					// 되어지게
					// 한다.
					jScrollPane1.setViewportView(mUidList);
					jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
					
					
					mUidList.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					//mUidList.setPreferredSize(new java.awt.Dimension(586, 222));	/이거 들어가면 안된다.
				}
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
				jPanel3.setBounds(12, 0, 579, 31);
				{
					dd = new JLabel();
					jPanel3.add(dd);
					dd.setText("Power Tutor Trace");
					dd.setPreferredSize(new java.awt.Dimension(106, 17));
				}
			}
			{
				jPanel5 = new JPanel();
				getContentPane().add(jPanel5, "West");
				jPanel5.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
				jPanel5.setBounds(12, 356, 304, 58);
				jPanel5.setLayout(null);
				{
					Range = new JLabel();
					jPanel5.add(Range);
					Range.setText("Range");
					Range.setBounds(14, 10, 46, 17);
				}
				{
					mFirstRangeText = new JTextField();
					jPanel5.add(mFirstRangeText);
					mFirstRangeText.setBounds(59, 7, 63, 24);
				}
				{
					mUidPieDiagramBtn = new JButton();
					jPanel5.add(mUidPieDiagramBtn);
					mUidPieDiagramBtn.setText("UID Pie");
					mUidPieDiagramBtn.setBounds(207, 7, 90, 24);
				}
				{
					jLabel3 = new JLabel();
					jPanel5.add(jLabel3);
					jLabel3.setText("-");
					jLabel3.setBounds(128, 10, 10, 17);
				}
				{
					mSecondRangeText = new JTextField();
					jPanel5.add(mSecondRangeText);
					mSecondRangeText.setBounds(138, 7, 63, 24);
				}
				{
					mComponentPieBtn = new JButton();
					jPanel5.add(mComponentPieBtn);
					mComponentPieBtn.setText("PHONE Pie");
					mComponentPieBtn.setBounds(59, 36, 238, 16);
				}
			}
			{
				jPanel6 = new JPanel();
				getContentPane().add(jPanel6, "West");
				jPanel6.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
				jPanel6.setBounds(322, 356, 275, 66);
				jPanel6.setLayout(null);
				{
					jLabel4 = new JLabel();
					jPanel6.add(jLabel4);
					jLabel4.setText("TotalPM");
					jLabel4.setBounds(16, 10, 56, 26);
				}
				{
					mChartMeanUnitTextField = new JTextField();
					jPanel6.add(mChartMeanUnitTextField);
					mChartMeanUnitTextField.setBounds(77, 7, 135, 29);
				}
				{
					m3DBarChartMean = new JButton();
					jPanel6.add(m3DBarChartMean);
					m3DBarChartMean.setText("ok");
					m3DBarChartMean.setBounds(218, 7, 49, 24);
				}
				{
					mAudioCheckBox = new JCheckBox();
					jPanel6.add(mAudioCheckBox);
					mAudioCheckBox.setText("AUDIO");
					mAudioCheckBox.setBounds(79, 40, 65, 21);
				}
				{
					mGPSCheckBox = new JCheckBox();
					jPanel6.add(mGPSCheckBox);
					mGPSCheckBox.setText("GPS");
					mGPSCheckBox.setBounds(151, 40, 56, 21);
				}
			}
			{
				jPanel4 = new JPanel();
				getContentPane().add(jPanel4, "North");
				FlowLayout jPanel4Layout = new FlowLayout();
				jPanel4.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				jPanel4.setLayout(jPanel4Layout);
				jPanel4.setBounds(12, 523, 590, 66);
				{
					mAppTotalPowerBtn = new JButton();
					jPanel4.add(mAppTotalPowerBtn);
					mAppTotalPowerBtn.setText("UID Line Total Power");
					mAppTotalPowerBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mAppStackedPower = new JButton();
					jPanel4.add(mAppStackedPower);
					mAppStackedPower.setText("UID Stack Total Power");
					mAppStackedPower.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mLedBtn = new JButton();
					jPanel4.add(mLedBtn);
					mLedBtn.setText("UID LED Power");
					mLedBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mCpuBtn = new JButton();
					jPanel4.add(mCpuBtn);
					mCpuBtn.setText("UID CPU Power");
					mCpuBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mWifiBtn = new JButton();
					jPanel4.add(mWifiBtn);
					mWifiBtn.setText("UID WIFI Power");
					mWifiBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					m3GBtn = new JButton();
					jPanel4.add(m3GBtn);
					m3GBtn.setText("UID ThreeG Power");
					m3GBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
			}
			{
				jPanel7 = new JPanel();
				getContentPane().add(jPanel7, "North");
				FlowLayout jPanel7Layout = new FlowLayout();
				jPanel7.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				jPanel7.setLayout(jPanel7Layout);
				jPanel7.setBounds(12, 618, 590, 63);
				{
					mComponentLEDBtn = new JButton();
					jPanel7.add(mComponentLEDBtn);
					mComponentLEDBtn.setText("LED Power");
					mComponentLEDBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mComponentWIFIBtn = new JButton();
					jPanel7.add(mComponentWIFIBtn);
					mComponentWIFIBtn.setText("WIFI Power");
					mComponentWIFIBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mGpsBtn = new JButton();
					jPanel7.add(mGpsBtn);
					mGpsBtn.setText("GPS Power");
					mGpsBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mComponentCPUBtn = new JButton();
					jPanel7.add(mComponentCPUBtn);
					mComponentCPUBtn.setText("CPU Power");
					mComponentCPUBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mComponentThreeGBtn = new JButton();
					jPanel7.add(mComponentThreeGBtn);
					mComponentThreeGBtn.setText("ThreeG Power");
					mComponentThreeGBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
				{
					mAudioBtn = new JButton();
					jPanel7.add(mAudioBtn);
					mAudioBtn.setText("AUDIO Power");
					mAudioBtn.setPreferredSize(new java.awt.Dimension(140, 24));
				}
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Individual App component Power");
				jLabel1.setBounds(12, 506, 202, 17);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Function Button");
				jLabel2.setBounds(12, 411, 181, 17);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Individual H/W Component Power");
				jLabel5.setBounds(12, 601, 223, 17);
			}
			{
				jScrollPane2 = new JScrollPane();
				getContentPane().add(jScrollPane2);
				jScrollPane2.setBounds(493, 122, 108, 194);
				{
					listModelUidDelte = new DefaultListModel();// List의 데이터를 관리하는 모델이다.
					mDeleteList = new JList(listModelUidDelte);
					jScrollPane2.setViewportView(mDeleteList);
				}
			}
			{
				mDeleteAllBtn = new JButton();
				getContentPane().add(mDeleteAllBtn);
				mDeleteAllBtn.setText("A");
				mDeleteAllBtn.setBounds(493, 321, 51, 24);
			}
			{
				mDeleteOneBtn = new JButton();
				getContentPane().add(mDeleteOneBtn);
				mDeleteOneBtn.setText("O");
				mDeleteOneBtn.setBounds(549, 321, 48, 24);
			}
			{
				mDeleteUidMoveBtn = new JButton();
				getContentPane().add(mDeleteUidMoveBtn);
				mDeleteUidMoveBtn.setText(">");
				mDeleteUidMoveBtn.setBounds(443, 169, 45, 95);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Package Name List");
				jLabel6.setBounds(13, 99, 139, 17);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Remove Uid");
				jLabel7.setBounds(493, 100, 139, 17);
			}
			pack();
			this.setSize(623, 725);
			// setVisible(true);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	// 버튼 클릭시 수행되어 지는 리스너 이다.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == mFileBtn) {
			if (mJFileChooser != null) {
				// 지난번 선택한 파일의 위치를 기억하기 위한 작업이다.
				if (mFileName != null) {
					String dir = mFileName.getAbsolutePath(); // 현재 파일이 위치하는
					// 디레토리를 가져 온다.
					mJFileChooser = new JFileChooser(dir);
				}
				int returnVal = mJFileChooser.showOpenDialog(this);

				if (returnVal != JFileChooser.APPROVE_OPTION)
					return; // 열기를 하지 않았다면 바로 리턴한다.

				mFileName = mJFileChooser.getSelectedFile();
				mFilePathTextField.setText(mFileName.getAbsolutePath());

			}
		} else if (e.getSource() == mGPSCheckBox) {
			FLAG_GPS_STATE = mGPSCheckBox.isSelected();
		} else if (e.getSource() == mAudioCheckBox) {
			FLAG_AUDIO_STATE = mAudioCheckBox.isSelected();
		} else if (e.getSource() == mParsingBtn) {
			// List를 초기화 한다.
			listModel.clear();
			// 우선 첫번째로 선택한 파일의 이름르 전달 한다.
			mCFileStream.setFileName(mFileName.getAbsolutePath());
			// UID를 추출하는 작업을 한다. 을하여 결과를 전송 받는다.
			try {
				mUidArrayList = mCFileStream.ParsingUID();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (int i = 0; i < mUidArrayList.size(); i++) {
				listModel.addElement(mUidArrayList.get(i));
			}
		} else if (e.getSource() == mTotalPowerBtn) {
			try {
				int LastUnit = 50; // 마지막 값을 계산하기 위한 변수이다.
				double totalSum = 0.0, mean = 0.0;
				// 총 전력값을 추출하여 얻어온다.
				mTotalPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_POWER);
				//시간정보를 읽어 온다.
				mTimeArrayList = mCFileStream.ParsingTime();
				//파일 입출력 부분
				PrintWriter out = new PrintWriter(new FileWriter("TotalPower.txt"));
				for (int i = 0; i < mTotalPowerArrayList.size(); i++) {
					out.printf("%s %d\n",mTimeArrayList.get(i),mTotalPowerArrayList.get(i));
					out.flush();
				}
				out.close();
				
				/*
				// 50초마다 묶어서 평균을 계산 한다.
				for (int i = 0; i < mTotalPowerArrayList.size(); i += 50) {
					totalSum = 0.0; // 초기화를 해준다.
					mean = 0.0;
					for (int j = 0; j < 50; j++) {
						if ((j + i) >= mTotalPowerArrayList.size()) {
							LastUnit = j;
							break; // 더이상 연산하지 않고 빠져나간다.
						}
						totalSum += mTotalPowerArrayList.get(j + i);
					}
					mean = totalSum / LastUnit;
					System.out.printf("%f\n", mean);
				}*/
				
				LineGraphGenerate(mTotalPowerArrayList, "Line Graph",
						"Total Power Consumption", "Total Power Value");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//총 파워를 stack 그래프로 그려주는 이벤트 처리
		else if(e.getSource() == mPhoneTotalStackPowerBtn){
			try {
				
				//삭제리스트가 없을 경우
				if(listModelUidDelte.getSize() == 0){
					//각 H/W별 component 단위로 Stack Grap을 그린다. 이 Grap은 Line그래프의 내용물이 될 것이다.
					StackedXYAreaRenderer(
							mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_CPU_POWER),
							mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_WIFI_POWER),
							mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_LED_POWER),
							mCFileStream.ParsingPowerConsumption(mSearchUid, GPS_POWER),
							mCFileStream.ParsingPowerConsumption(mSearchUid, AUDIO_POWER),
							mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_THREEG_POWER)
							);
				}
				else {
					//일단 전체값을 구해서 arraylist에 집어 넣는다.
					mCpuPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_CPU_POWER);
					mWifiPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_WIFI_POWER);
					mLedPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_LED_POWER);
					mThreeGPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_THREEG_POWER);
					mGpsPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, GPS_POWER);
					mAudioPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, AUDIO_POWER);
					
					//삭제 리스트에 있는 UID의 Power값들은 전체에서 제거되어 그래프를 그리기위해서 ArrayList를 만들어 준다.
					processUidDeletePower();
					//CPU,WIFI,LED,GPS,AUDIO,3G 순서로 들어가야한다.
					StackedXYAreaRenderer(mCpuPowerArrayList,
							mWifiPowerArrayList,
							mLedPowerArrayList,
							mGpsPowerArrayList,
							mAudioPowerArrayList,
							mThreeGPowerArrayList);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == mBatteryCapacityBtn) {
			try {
				mBatteryCapacityArrayList = mCFileStream
						.ParsingPowerConsumption(mSearchUid, BATTERY_CAPACITY);
				LineGraphGenerate(mBatteryCapacityArrayList, "Line Graph",
						"Battery Capacity", "Battery Capacity (%)");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == mCpuBtn) {
			try {
				mCpuPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, CPU_POWER);
				LineGraphGenerate(mCpuPowerArrayList, "Line Graph",
						"CPU Power Consumption", "CPU Power Value");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == mWifiBtn) {
			try {
				mWifiPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, WIFI_POWER);
				LineGraphGenerate(mWifiPowerArrayList, "Line Graph",
						"WIFI Power Consumption", "WIFI Power Value");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == m3GBtn) {
			try {
				mThreeGPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, THREEG_POWER);
				LineGraphGenerate(mThreeGPowerArrayList, "Line Graph",
						"ThreeG Power Consumption", "ThreeG Power Value");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource() == mLedBtn) {
			try {
				mLedPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, LED_POWER);
				LineGraphGenerate(mLedPowerArrayList, "Line Graph",
						"LED Power Consumption", "LED Power Value");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == mGpsBtn) {
			try {
				mGpsPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, GPS_POWER);
				LineGraphGenerate(mGpsPowerArrayList, "Line Graph",
						"GPS Power Consumption", "GPS Power Value");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == mAudioBtn) {
			try {
				mAudioPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, AUDIO_POWER);
				LineGraphGenerate(mAudioPowerArrayList, "Line Graph",
						"AUDIO Power Consumption", "Audio Power Value");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//각 하드웨어 컴포넌트별 파워를 계산한다. (UID 별이 아니다.)
		else if(e.getSource() == mComponentWIFIBtn){
			try {
				mComponentWifiArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_WIFI_POWER);
				LineGraphGenerate(mComponentWifiArrayList, "Line Graph",
						"ComponentWifi Power Consumption", "ComponentWifi Power Value");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// 각 디바이스별 최대 파워를 계산하는 기능이다.
		else if (e.getSource() == mDevicesPowerButton) {

			int maxCPU = 0;
			int maxWIFI = 0;
			int maxThree = 0;
			int maxLED = 0;
			int maxGPS = 0;
			int maxAUDIO = 0;

			try {
				maxCPU = maxEvaluation(mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_CPU_POWER));
				maxWIFI = maxEvaluation(mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_WIFI_POWER));
				maxThree = maxEvaluation(mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_THREEG_POWER));
				maxLED = maxEvaluation(mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_LED_POWER));
				maxGPS = maxEvaluation(mCFileStream.ParsingPowerConsumption(
						mSearchUid, GPS_POWER));
				maxAUDIO = maxEvaluation(mCFileStream.ParsingPowerConsumption(
						mSearchUid, AUDIO_POWER));

				System.out.println("CPU " + maxCPU);
				System.out.println("WIFI " + maxWIFI);
				System.out.println("3G " + maxThree);
				System.out.println("LED " + maxLED);
				System.out.println("GPS " + maxGPS);
				System.out.println("AUDIO " + maxAUDIO);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		//Component Pipe Diagram make function.
		else if(e.getSource() == mComponentPieBtn){
			double[] value = new double[6];
			String[] group = new String[6];
			group[0] = "CPU Power";
			group[1] = "WIFI Power";
			group[2] = "LED Power";
			group[3] = "GPS Power";
			group[4] = "AUDIO Power";
			group[5] = "3G Power";
			value[0] = 0.0;
			value[1] = 0.0;
			value[2] = 0.0;
			value[3] = 0.0;
			value[4] = 0.0;
			value[5] = 0.0;
			
			int totalPowerValue = 0;
			if (mFirstRangeText.getText() != "") {
				// 입력 범위를 추출한다.
				mFirstRange = Integer.parseInt(mFirstRangeText.getText());
				mSecondRange = Integer.parseInt(mSecondRangeText.getText());

				// 분포를 계산하기 위함이다.
				try {
					mCpuPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_CPU_POWER);
					mWifiPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_WIFI_POWER);
					mLedPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_LED_POWER);
					mGpsPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, GPS_POWER);
					mAudioPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, AUDIO_POWER);
					mThreeGPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, TOTAL_THREEG_POWER);
				
					processUidDeletePower(); // 삭제 리스트의 것을 삭제한다.
					
					for (int i = mFirstRange; i <= mSecondRange; i++) {
						// 추출한 전력값을 노드에 하나하나 대입한다.
						value[0] += (double) mCpuPowerArrayList.get(i);
						value[1] += (double) mWifiPowerArrayList.get(i);
						value[2] += (double) mLedPowerArrayList.get(i);
						value[5] += (double) mThreeGPowerArrayList.get(i);
						if (FLAG_GPS_STATE == true && FLAG_AUDIO_STATE == true) {
							value[3] += (double) mGpsPowerArrayList.get(i);
							value[4] += (double) mAudioPowerArrayList.get(i);
						} else if (FLAG_GPS_STATE == true
								&& FLAG_AUDIO_STATE == false) {
							value[3] += (double) mGpsPowerArrayList.get(i);
							value[4] = 0.0;
						} else if (FLAG_GPS_STATE == false
								&& FLAG_AUDIO_STATE == true) {
							value[3] = 0.0;
							value[4] += (double) mAudioPowerArrayList.get(i);
						}
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				PieGraphGenerate(group, value, "", "");
			}
		}
		// Pipe 다이어그램을 그리라는 동작을 수행할 경우
		else if (e.getSource() == mUidPieDiagramBtn) {
			double[] value = new double[6];
			String[] group = new String[6];
			group[0] = "CPU Power";
			group[1] = "WIFI Power";
			group[2] = "LED Power";
			group[3] = "GPS Power";
			group[4] = "AUDIO Power";
			group[5] = "3G Power";
			value[0] = 0.0;
			value[1] = 0.0;
			value[2] = 0.0;
			value[3] = 0.0;
			value[4] = 0.0;
			value[5] = 0.0;

			int totalPowerValue = 0;
			if (mFirstRangeText.getText() != "") {
				// 입력 범위를 추출한다.
				mFirstRange = Integer.parseInt(mFirstRangeText.getText());
				mSecondRange = Integer.parseInt(mSecondRangeText.getText());

				// 분포를 계산하기 위함이다.
				try {
					mCpuPowerArrayList = mCFileStream.ParsingPowerConsumption(
							mSearchUid, CPU_POWER);
					mWifiPowerArrayList = mCFileStream.ParsingPowerConsumption(
							mSearchUid, WIFI_POWER);
					mLedPowerArrayList = mCFileStream.ParsingPowerConsumption(
							mSearchUid, LED_POWER);
					mGpsPowerArrayList = mCFileStream.ParsingPowerConsumption(
							mSearchUid, GPS_POWER);
					mAudioPowerArrayList = mCFileStream
							.ParsingPowerConsumption(mSearchUid, AUDIO_POWER);
					mThreeGPowerArrayList = mCFileStream.ParsingPowerConsumption(mSearchUid, THREEG_POWER);
					
					// 토탈 파워의 누적값을 계산 하기 위함 이다.
					mTotalPowerArrayList = mCFileStream
							.ParsingPowerConsumption(mSearchUid, TOTAL_POWER);

					for (int i = mFirstRange; i <= mSecondRange; i++) {
						// 추출한 전력값을 노드에 하나하나 대입한다.
						value[0] += (double) mCpuPowerArrayList.get(i);
						value[1] += (double) mWifiPowerArrayList.get(i);
						value[2] += (double) mLedPowerArrayList.get(i);
						value[5] += (double) mThreeGPowerArrayList.get(i);
						if (FLAG_GPS_STATE == true && FLAG_AUDIO_STATE == true) {
							value[3] += (double) mGpsPowerArrayList.get(i);
							value[4] += (double) mAudioPowerArrayList.get(i);
						} else if (FLAG_GPS_STATE == true
								&& FLAG_AUDIO_STATE == false) {
							value[3] += (double) mGpsPowerArrayList.get(i);
							value[4] = 0.0;
						} else if (FLAG_GPS_STATE == false
								&& FLAG_AUDIO_STATE == true) {
							value[3] = 0.0;
							value[4] += (double) mAudioPowerArrayList.get(i);
						}
						totalPowerValue += mTotalPowerArrayList.get(i);
					}
					System.out.println(totalPowerValue);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				PieGraphGenerate(group, value, "", "");
			}
		}
		//Component별 차트를 그린다.
		else if(e.getSource() == mComponentLEDBtn){
			
		}
		// 3D bar chart를 Range만큼 평균을 내어서 보여준다.
		else if (e.getSource() == m3DBarChartMean) {
			int unit = 0;
			int sumCPU = 0;
			int sumWIFI = 0;
			int sumLED = 0;
			int sumGPS = 0;
			int sumAUDIO = 0;
			int sumThree = 0;
			int totalsum = 0;
			int powtotalsum = 0;
			int LastUnit = 0;
			double mean;
			double totalmean;
			double Powe2mean;
			boolean flagGPS = false;
			boolean flagAUDIO = false;

			// 체크 박스의 체크여부를 가져온다.
			flagGPS = mGPSCheckBox.isSelected();
			flagAUDIO = mAudioCheckBox.isSelected();

			ArrayList<Double> mTotalArrayList = new ArrayList<Double>();
			ArrayList<Double> mUnitCPUArrayList = new ArrayList<Double>();
			ArrayList<Double> mUnitWIFIPowerArrayList = new ArrayList<Double>();
			ArrayList<Double> mUnitThreePowerArrayList = new ArrayList<Double>();
			ArrayList<Double> mUnitLEDPowerArrayList = new ArrayList<Double>();
			ArrayList<Double> mUnitGPSPowerArrayList = new ArrayList<Double>();
			ArrayList<Double> mUnitAUDIOPowerArrayList = new ArrayList<Double>();

			if (mChartMeanUnitTextField.getText() != "") {
				unit = Integer.parseInt(mChartMeanUnitTextField.getText());
				// 맨마지막 평균은 입력한 단위만큼 딱 맞게 끝나지 않을 수도있다. (e.g 1분단위로 평균이지만 데이터가 40초
				// 정도꺼 밖에 없을 수도있다.
				// 따라서 동적으로 마지막 평균 단위를 계싼해서 계산해 주기 위해서 이러한 변수를 추가 하였다.
				LastUnit = Integer.parseInt(mChartMeanUnitTextField.getText());
			}
			// 전체의 Power를 읽어 온다.
			try {
				
				mCpuPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_CPU_POWER);
				mWifiPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_WIFI_POWER);
				mThreeGPowerArrayList  = mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_THREEG_POWER);
				mLedPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, TOTAL_LED_POWER);
				mGpsPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, GPS_POWER);
				mAudioPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, AUDIO_POWER);

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			//삭제할 list를 기반으로 삭제 한다.
			processUidDeletePower();
			
			// unit 단위만큼 평균을 계산 한다.
			for (int i = 0; i < mCpuPowerArrayList.size(); i += unit) {
				sumCPU = 0;
				sumWIFI = 0;
				sumThree = 0;
				sumLED = 0;
				sumGPS = 0;
				sumAUDIO = 0;
				

				totalsum = 0;
				powtotalsum = 0;

				for (int j = 0; j < unit; j++) {
					if ((j + i) >= mCpuPowerArrayList.size()) {
						// 이변수를 저장해 주어야 한다. 이것으로 마지막 평균을 계산하게 된다.
						LastUnit = j; // 마지막에 존재하는 사이즈를 저장해 준다.
						break;
					}
					sumCPU += mCpuPowerArrayList.get(j + i);
					sumWIFI += mWifiPowerArrayList.get(j + i);
					sumThree += mThreeGPowerArrayList.get(j+i);
					sumLED += mLedPowerArrayList.get(j + i);
					

					// 변량의 제곱의 합을 구한다.
					if (flagGPS == true && flagAUDIO == true) {
						sumGPS += mGpsPowerArrayList.get(j + i);
						sumAUDIO += mAudioPowerArrayList.get(j + i);

						totalsum = mCpuPowerArrayList.get(j + i)
								+ mWifiPowerArrayList.get(j + i)
								+ mThreeGPowerArrayList.get(j+i)
								+ mLedPowerArrayList.get(j + i)
								+ mGpsPowerArrayList.get(j + i)
								+ mAudioPowerArrayList.get(j + i);

					} else if (flagGPS == true && flagAUDIO == false) {
						sumGPS += mGpsPowerArrayList.get(j + i);

						totalsum = mCpuPowerArrayList.get(j + i)
								+ mWifiPowerArrayList.get(j + i)
								+ mThreeGPowerArrayList.get(j+i)
								+ mLedPowerArrayList.get(j + i)
								+ mGpsPowerArrayList.get(j + i);
					} else if (flagGPS == false && flagAUDIO == true) {
						sumAUDIO += mAudioPowerArrayList.get(j + i);

						totalsum = mCpuPowerArrayList.get(j + i)
								+ mWifiPowerArrayList.get(j + i)
								+ mThreeGPowerArrayList.get(j+i)
								+ mLedPowerArrayList.get(j + i)
								+ mAudioPowerArrayList.get(j + i);
					} else {
						totalsum = mCpuPowerArrayList.get(j + i)
								+ mWifiPowerArrayList.get(j + i)
								+ mThreeGPowerArrayList.get(j+i)
								+ mLedPowerArrayList.get(j + i);
					}
					powtotalsum += (int) Math.pow(totalsum, 2);
					totalsum = 0;

				}

				/*
				 * LastUnit은 break문이 불리지 않는다면 항상 사용자가 입력한 값으로 계산 되어 진다. 또한 사용자의
				 * 체크박스 선택 여부에 따라 다르게 계산되어 진다.
				 */
				mean = sumCPU / LastUnit;
				mUnitCPUArrayList.add(mean);
				mean = sumWIFI / LastUnit;
				mUnitWIFIPowerArrayList.add(mean);
				mean = sumThree / LastUnit;
				mUnitThreePowerArrayList.add(mean);
				mean = sumLED / LastUnit;
				mUnitLEDPowerArrayList.add(mean);

				if ((flagGPS == true) && (flagAUDIO == true)) {
					mean = sumGPS / LastUnit;
					mUnitGPSPowerArrayList.add(mean);
					mean = sumAUDIO / LastUnit;
					mUnitAUDIOPowerArrayList.add(mean);

					totalmean = (sumCPU + sumWIFI + sumThree + sumLED + sumGPS + sumAUDIO)
							/ LastUnit;
					// 표준편차를 구한다.
					Powe2mean = Math
							.sqrt((powtotalsum / LastUnit)
									- Math
											.pow(
													((sumCPU + sumWIFI + sumThree + sumLED
															+ sumGPS + sumAUDIO) / LastUnit),
													2));
					//실험 편의를 위해서 수정 한다.
/*					System.out.println((i / 60) + ": 평균: " + totalmean
							+ " 표준편차: " + Powe2mean);*/
					System.out.println(""+totalmean);
				} else if ((flagGPS == true) && (flagAUDIO == false)) {
					mean = sumGPS / LastUnit;
					mUnitGPSPowerArrayList.add(mean);
					mUnitAUDIOPowerArrayList.add(0.0);

					totalmean = (sumCPU + sumWIFI + sumLED + sumGPS) / LastUnit;
					// 표준편차를 구한다.
					Powe2mean = Math
							.sqrt((powtotalsum / LastUnit)
									- Math
											.pow(
													((sumCPU + sumWIFI + sumThree + sumLED + sumGPS) / LastUnit),
													2));
					/*System.out.println((i / 60) + ": 평균: " + totalmean
							+ " 표준편차: " + Powe2mean);*/
					System.out.println(""+totalmean);
				} else if (flagGPS == false && flagAUDIO == true) {
					mUnitGPSPowerArrayList.add(0.0);
					mean = sumAUDIO / LastUnit;
					mUnitAUDIOPowerArrayList.add(mean);

					totalmean = (sumCPU + sumWIFI + sumLED + sumAUDIO)
							/ LastUnit;
					// 표준편차를 구한다.
					Powe2mean = Math
							.sqrt((powtotalsum / LastUnit)
									- Math
											.pow(
													((sumCPU + sumWIFI + sumThree + sumLED + sumAUDIO) / LastUnit),
													2));
					/*System.out.println((i / 60) + ": 평균: " + totalmean
							+ " 표준편차: " + Powe2mean);*/
					System.out.println(""+totalmean);
				} else {
					mUnitGPSPowerArrayList.add(0.0);
					mUnitAUDIOPowerArrayList.add(0.0);

					totalmean = (sumCPU + sumWIFI + sumLED) / LastUnit;
					// 표준편차를 구한다.
					Powe2mean = Math
							.sqrt((powtotalsum / LastUnit)
									- Math
											.pow(
													((sumCPU + sumWIFI + sumThree + sumLED) / LastUnit),
													2));
					/*System.out.println((i / 60) + ": 평균: " + totalmean
							+ " 표준편차: " + Powe2mean);*/
					System.out.println(""+totalmean);
				}

			}
			
			for(int i = 0; i<mUnitCPUArrayList.size(); i++){
				double sum = mUnitCPUArrayList.get(i)+ 
				mUnitWIFIPowerArrayList.get(i) +
				mUnitThreePowerArrayList.get(i) +
				mUnitLEDPowerArrayList.get(i) +
				mUnitGPSPowerArrayList.get(i) +
				mUnitAUDIOPowerArrayList.get(i); 
				System.out.println(""+sum);
			}
			// 3D bar chart를 평균값으로 그린다.
			StackedBarChart3D(mUnitCPUArrayList, mUnitWIFIPowerArrayList, mUnitThreePowerArrayList,
					mUnitLEDPowerArrayList, mUnitGPSPowerArrayList,
					mUnitAUDIOPowerArrayList);

		}
		// 각 App별 Line 그래프 이다.
		else if (e.getSource() == mAppTotalPowerBtn) {
			int totalPower;
			ArrayList<Integer> mUidTotalPowerArrayList = new ArrayList<Integer>();
			try {

				mCpuPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, CPU_POWER);
				mWifiPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, WIFI_POWER);
				mLedPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, LED_POWER);
				mGpsPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, GPS_POWER);
				mAudioPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, AUDIO_POWER);

				/* log 사이즈를 출력한다 */
				mLogScaleTextFiled.setText(String.format("%d",
						mCpuPowerArrayList.size() - 1));

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// uid별 파워를 누적해서 Line Grahp로 그린다.
			for (int i = 0; i < mCpuPowerArrayList.size(); i++) {
				totalPower = mCpuPowerArrayList.get(i)
						+ mWifiPowerArrayList.get(i)
						+ mLedPowerArrayList.get(i);
				if (FLAG_GPS_STATE == true && FLAG_AUDIO_STATE == true) {
					totalPower += mGpsPowerArrayList.get(i)
							+ mAudioPowerArrayList.get(i);
				} else if (FLAG_GPS_STATE == true && FLAG_AUDIO_STATE == false) {
					totalPower += mGpsPowerArrayList.get(i);
				} else if (FLAG_GPS_STATE == false && FLAG_AUDIO_STATE == true) {
					totalPower += mAudioPowerArrayList.get(i);
				}
				mUidTotalPowerArrayList.add(totalPower);
			}
			LineGraphGenerate(mUidTotalPowerArrayList, "Line Graph",
					"App Total Power", "Power Value");
		}
		// 각 App별 XY Area 차트이다.
		else if (e.getSource() == mAppStackedPower) {
			try {
				mCpuPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, CPU_POWER);
				mWifiPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, WIFI_POWER);
				mLedPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, LED_POWER);
				mGpsPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, GPS_POWER);
				mAudioPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, AUDIO_POWER);
				mThreeGPowerArrayList = mCFileStream.ParsingPowerConsumption(
						mSearchUid, THREEG_POWER);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			StackedXYAreaRenderer(mCpuPowerArrayList, mWifiPowerArrayList,
					mLedPowerArrayList, mGpsPowerArrayList,
					mAudioPowerArrayList,mThreeGPowerArrayList);
		}
		//삭제 List에 이동을 시키는 것
		else if(e.getSource() == mDeleteUidMoveBtn){
			listModelUidDelte.addElement(mSearchUid); //선택한 UID를 삭제할 UID List로 이동 시킨다.
		}
		//삭제 List에서 모든 UID 삭제
		else if(e.getSource() == mDeleteAllBtn){
			listModelUidDelte.clear();
		}
		//삭제 List에서 선택한 UID만 삭제
		else if(e.getSource() == mDeleteOneBtn){
			listModelUidDelte.remove(mDeleteList.getSelectedIndex());
			
		}
		//총 파워 소비를 비교해서 위한 그래프이다.
		else if(e.getSource() == mTotalCompareBtn){
			DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
			DefaultStatisticalCategoryDataset defaultstatisticalcategorydataset = new DefaultStatisticalCategoryDataset();
			
			//마이피플 (음성) sd 157.97
			defaultcategorydataset.addValue(167, "CPU Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(400, "WIFI Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(0, "LED Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "MYPEOPLE-Voice");
			//마이피플(영상) sd 144.44
			defaultcategorydataset.addValue(197, "CPU Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(404, "WIFI Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(399, "LED Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "MYPEOPLE-Video");
			//카카오톡 sd : 246.80
			defaultcategorydataset.addValue(91, "CPU Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(110, "WIFI Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(454, "LED Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "KAKAo-Talk");
			//앵그리버드 sd : 188.30
			defaultcategorydataset.addValue(134, "CPU Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(66, "WIFI Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(528, "LED Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(103, "AUDIO Power(mW)", "Angry-Birds");
			//유투브 sd : 233.50
			defaultcategorydataset.addValue(40, "CPU Power(mW)", "Youtube");
			defaultcategorydataset.addValue(131, "WIFI Power(mW)", "Youtube");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "Youtube");
			defaultcategorydataset.addValue(474, "LED Power(mW)", "Youtube");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "Youtube");
			defaultcategorydataset.addValue(91, "AUDIO Power(mW)", "Youtube");
			//웹브라우저  sd : 301.80
			defaultcategorydataset.addValue(382, "CPU Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(0, "WIFI Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(823, "3G Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(570, "LED Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "Web-Browser");
			
			defaultcategorydataset.addValue(60, "CPU Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(0, "WIFI Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(750, "3G Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(538, "LED Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(244, "GPS Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "Google-Map");

			JFreeChart jfreechart = ChartFactory.createStackedBarChart3D(
					"", "Application Name", "Power(mW)",
					defaultcategorydataset, PlotOrientation.HORIZONTAL, true, true,
					false);

			CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
			categoryplot.setBackgroundPaint(new Color(255,255,255));//배경색 설정
			// 구간을 분할하는 코드이다.
			// IntervalMarker intervalmarker = new IntervalMarker(5D, 10D,
			// Color.gray, new BasicStroke(0.5F), Color.blue, new BasicStroke(0.5F),
			// 0.5F);
			// categoryplot.addRangeMarker(intervalmarker);

			BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();
			barrenderer.setDrawBarOutline(false);
			barrenderer
					.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			barrenderer.setBaseItemLabelsVisible(true);
			barrenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.CENTER, TextAnchor.CENTER));
			barrenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.CENTER, TextAnchor.CENTER));

			// JFrame에 그리는 부분이다.
			ChartPanel chartPanel = new ChartPanel(jfreechart);
			JFrame f = new JFrame("");
			f.setSize(600, 600);
			f.getContentPane().add(chartPanel);

			// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			
		}
		//최고 피크 구간을 비교해서 그래프를 그려 준다. 
		else if(e.getSource() == mCompareAppPowerBtn){
			DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
			DefaultStatisticalCategoryDataset defaultstatisticalcategorydataset = new DefaultStatisticalCategoryDataset();
			
			//마이피플 (음성) sd 38.6
			defaultcategorydataset.addValue(313, "CPU Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(404, "WIFI Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(0, "LED Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "MYPEOPLE-Voice");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "MYPEOPLE-Voice");
			//마이피플(영상) sd 144.44
			defaultcategorydataset.addValue(277, "CPU Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(396, "WIFI Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(411, "LED Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "MYPEOPLE-Video");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "MYPEOPLE-Video");
			
			defaultcategorydataset.addValue(93, "CPU Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(166, "WIFI Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(465, "LED Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "KAKAo-Talk");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "KAKAo-Talk");
			
			defaultcategorydataset.addValue(149, "CPU Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(88, "WIFI Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(534, "LED Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "Angry-Birds");
			defaultcategorydataset.addValue(106, "AUDIO Power(mW)", "Angry-Birds");
			
			defaultcategorydataset.addValue(32, "CPU Power(mW)", "Youtube");
			defaultcategorydataset.addValue(136, "WIFI Power(mW)", "Youtube");
			defaultcategorydataset.addValue(0, "3G Power(mW)", "Youtube");
			defaultcategorydataset.addValue(520, "LED Power(mW)", "Youtube");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "Youtube");
			defaultcategorydataset.addValue(103, "AUDIO Power(mW)", "Youtube");
			
			defaultcategorydataset.addValue(411, "CPU Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(0, "WIFI Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(883, "3G Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(626, "LED Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(0, "GPS Power(mW)", "Web-Browser");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "Web-Browser");
			
			defaultcategorydataset.addValue(94, "CPU Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(0, "WIFI Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(902, "3G Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(581, "LED Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(268, "GPS Power(mW)", "Google-Map");
			defaultcategorydataset.addValue(0, "AUDIO Power(mW)", "Google-Map");

			JFreeChart jfreechart = ChartFactory.createStackedBarChart3D(
					"", "Application Name", "Power(mW)",
					defaultcategorydataset, PlotOrientation.HORIZONTAL, true, true,
					false);

			CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
			categoryplot.setBackgroundPaint(new Color(255,255,255));//배경색 설정
			// 구간을 분할하는 코드이다.
			// IntervalMarker intervalmarker = new IntervalMarker(5D, 10D,
			// Color.gray, new BasicStroke(0.5F), Color.blue, new BasicStroke(0.5F),
			// 0.5F);
			// categoryplot.addRangeMarker(intervalmarker);

			BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();
			barrenderer.setDrawBarOutline(false);
			barrenderer
					.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			barrenderer.setBaseItemLabelsVisible(true);
			barrenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.CENTER, TextAnchor.CENTER));
			barrenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.CENTER, TextAnchor.CENTER));

			// JFrame에 그리는 부분이다.
			ChartPanel chartPanel = new ChartPanel(jfreechart);
			JFrame f = new JFrame("");
			f.setSize(600, 600);
			f.getContentPane().add(chartPanel);

			// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			
		}
	}

	public int maxEvaluation(ArrayList<Integer> arArrayList) {
		int max = 0;
		for (int i = 0; i < arArrayList.size(); i++) {
			if (max < arArrayList.get(i)) {
				max = arArrayList.get(i);
			}
		}
		return max;
	}

	//list 선택될 경우 발생하는 리스너
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mUidList){
			// package name 에서 UID만 추출하기위해 index를 저장 할 변수를 설정 한다.
			int indexEnd = -1;
			if (e.getValueIsAdjusting() == false) {

				if (mUidList.getSelectedIndex() == -1) {
					// 선택된 것이 없으면 그래프와 관련된 버튼을 비 활성화 시킨다.
					ComponetStateChanger(POWER_BUTTON_OFF);
				} else {
					// 선택된 것이 있으면 텍스트 필드를 갱신한다.
					ComponetStateChanger(POWER_BUTTON_ON);
					mSearchUid = mUidList.getSelectedValue().toString();

					indexEnd = mSearchUid.indexOf(" ");
					mSearchUid = mSearchUid.substring(0, indexEnd);
					mFilePathTextField.setText(mSearchUid);
				}
			}
		}
		else if(e.getSource() == mDeleteList){
			
		}
	}

	//그래프에서 제거할 UID Power 값들을 계산하는 함수
	public void processUidDeletePower(){
		
		ArrayList<Integer> tempListCpu = new ArrayList<Integer>();
		ArrayList<Integer> tempListLed = new ArrayList<Integer>();
		ArrayList<Integer> tempListWiFi = new ArrayList<Integer>();
		ArrayList<Integer> tempList3G = new ArrayList<Integer>();
		
		//Power 삭제 리스트에 저장된 만큼 하나씩 불러와서 모든 컴포넌트에대해서 계산을 해준다.
		for(int i = 0; i < listModelUidDelte.getSize(); i++){
			try {
				//해당 UID로 CPU power 소모검색	
				tempListCpu = mCFileStream.ParsingPowerConsumption(listModelUidDelte.get(i).toString(), CPU_POWER);
				tempListLed = mCFileStream.ParsingPowerConsumption(listModelUidDelte.get(i).toString(), LED_POWER);
				tempListWiFi = mCFileStream.ParsingPowerConsumption(listModelUidDelte.get(i).toString(), WIFI_POWER);
				tempList3G = mCFileStream.ParsingPowerConsumption(listModelUidDelte.get(i).toString(), THREEG_POWER);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int j = 0; j < mCpuPowerArrayList.size(); j++){
				mCpuPowerArrayList.set(j, mCpuPowerArrayList.get(j) - tempListCpu.get(j) 
						< 0 ? 0 : mCpuPowerArrayList.get(j) - tempListCpu.get(j) );	//최종적으로 제거된 list가 만들어 진다.
				mLedPowerArrayList.set(j, mLedPowerArrayList.get(j) - tempListLed.get(j)
						< 0 ? 0 : mLedPowerArrayList.get(j) - tempListLed.get(j) );	//최종적으로 제거된 list가 만들어 진다
				mWifiPowerArrayList.set(j, mWifiPowerArrayList.get(j) - tempListWiFi.get(j)
						< 0 ? 0 : mWifiPowerArrayList.get(j) - tempListWiFi.get(j));	//최종적으로 제거된 list가 만들어 진다
				mThreeGPowerArrayList.set(j, mThreeGPowerArrayList.get(j) - tempList3G.get(j)
						< 0 ? 0 : mThreeGPowerArrayList.get(j) - tempList3G.get(j));	//최종적으로 제거된 list가 만들어 진다
			}
		}
	}
	
	// Device별 최대 파워 소모를 알려주는 그래프 이다.
	// 3차원 누적 막대 그래프.
	public void StackedBarChart3D(ArrayList<Double> arCpuArrayList,
			ArrayList<Double> arWifiArrayList, ArrayList<Double> arThreeArrayList,
			ArrayList<Double> arLedArrayList, ArrayList<Double> arGpsArrayList,
			ArrayList<Double> arAudioArrayList) {

		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();

		for (int i = 0; i < arCpuArrayList.size(); i++) {
			defaultcategorydataset.addValue(arCpuArrayList.get(i),
					"CPU Power(mW)", i + "");
			defaultcategorydataset.addValue(arWifiArrayList.get(i),
					"WIFI Power(mW)", i + "");
			defaultcategorydataset.addValue(arThreeArrayList.get(i),
					"3G Power(mW)", i + "");
			defaultcategorydataset.addValue(arLedArrayList.get(i),
					"LED Power(mW)", i + "");
			defaultcategorydataset.addValue(arGpsArrayList.get(i),
					"GPS Power(mW)", i + "");
			defaultcategorydataset.addValue(arAudioArrayList.get(i),
					"AUDIO Power(mW)", i + "");
		}

		JFreeChart jfreechart = ChartFactory.createStackedBarChart3D(
				"Stacked Bar Chart", "Time", "Power(mW)",
				defaultcategorydataset, PlotOrientation.VERTICAL, true, true,
				false);

		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
		// 구간을 분할하는 코드이다.
		// IntervalMarker intervalmarker = new IntervalMarker(5D, 10D,
		// Color.gray, new BasicStroke(0.5F), Color.blue, new BasicStroke(0.5F),
		// 0.5F);
		// categoryplot.addRangeMarker(intervalmarker);

		BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();
		barrenderer.setDrawBarOutline(false);
		barrenderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barrenderer.setBaseItemLabelsVisible(true);
		barrenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.CENTER, TextAnchor.CENTER));
		barrenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.CENTER, TextAnchor.CENTER));

		// JFrame에 그리는 부분이다.
		ChartPanel chartPanel = new ChartPanel(jfreechart);
		JFrame f = new JFrame("StackedXYAreaRenderer");
		f.setSize(600, 600);
		f.getContentPane().add(chartPanel);

		// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	// 누적 영역 그래프이다.
	public void StackedXYAreaRenderer(ArrayList<Integer> arCpuArrayList,
			ArrayList<Integer> arWifiArrayList,
			ArrayList<Integer> arLedArrayList,
			ArrayList<Integer> arGpsArrayList,
			ArrayList<Integer> arAudioArrayList,
			ArrayList<Integer> arThreeGArrayList) {

		boolean flagGPS, flagAUDIO;
		flagGPS = mGPSCheckBox.isSelected();
		flagAUDIO = mAudioCheckBox.isSelected();
	
		XYSeries xyseriesCPU = new XYSeries("CPU");
		XYSeries xyseriesWIFI = new XYSeries("WIFI");
		XYSeries xyseriesThreeG = new XYSeries("3G");
		XYSeries xyseriesLED = new XYSeries("LED");
		XYSeries xyseriesGPS = new XYSeries("GPS");
		XYSeries xyseriesAUDIO = new XYSeries("AUDIO");
		
		for (int i = 0; i < arCpuArrayList.size(); i++) {
			//Power Tutor Bug 수정
			if (arCpuArrayList.get(i) > 450) {
				arCpuArrayList.set(i, 450);
			}
			/*
			 * stack 계층도 (Top -> bottom)
			 * AUDIO / GPS / LED / ThreeG / WIFI / CPU
			 */
			xyseriesCPU.add(i, arCpuArrayList.get(i));
			xyseriesWIFI.add(i, arWifiArrayList.get(i) + arCpuArrayList.get(i));
			xyseriesThreeG.add(i,arThreeGArrayList.get(i) + arWifiArrayList.get(i) 
					+ arCpuArrayList.get(i));
			xyseriesLED.add(i, arLedArrayList.get(i) + arThreeGArrayList.get(i) 
					+ arWifiArrayList.get(i) + arCpuArrayList.get(i));
			
			if (flagGPS == true && flagAUDIO == true) {
				xyseriesGPS.add(i, arGpsArrayList.get(i) + arLedArrayList.get(i)
						+ arThreeGArrayList.get(i) + arWifiArrayList.get(i) + arCpuArrayList.get(i));    
				
				xyseriesAUDIO.add(i, arAudioArrayList.get(i) + arGpsArrayList.get(i)
						+ arLedArrayList.get(i) + arThreeGArrayList.get(i) 
						+ arWifiArrayList.get(i) + arCpuArrayList.get(i));
				
			} else if (flagGPS == true && flagAUDIO == false) {
				xyseriesGPS.add(i, arGpsArrayList.get(i)
						+ arLedArrayList.get(i) + arThreeGArrayList.get(i)
						+ arWifiArrayList.get(i) + arCpuArrayList.get(i));
				
				xyseriesAUDIO.add(i, 0);	// AUDIO는 반영 시키지 않는다.
			} else if (flagGPS == false && flagAUDIO == true) {
				xyseriesGPS.add(i, 0);	//GPS는 반영 시키지 않는다.
				xyseriesAUDIO.add(i, arAudioArrayList.get(i) 
						+ arLedArrayList.get(i) + arThreeGArrayList.get(i) 
						+ arWifiArrayList.get(i) + arCpuArrayList.get(i));
			} else {
				xyseriesGPS.add(i, 0);   //GPS는 반영 시키지 않는다.
				xyseriesAUDIO.add(i, 0); // AUDIO는 반영 시키지 않는다.
			}
		}

		XYSeriesCollection xyseriescollection = new XYSeriesCollection();
		xyseriescollection.addSeries(xyseriesCPU);
		xyseriescollection.addSeries(xyseriesWIFI);
		xyseriescollection.addSeries(xyseriesThreeG);
		xyseriescollection.addSeries(xyseriesLED);
		xyseriescollection.addSeries(xyseriesGPS);
		xyseriescollection.addSeries(xyseriesAUDIO);

		JFreeChart jfreechart = ChartFactory.createXYLineChart("", "Time(sec)",
				"Power(mW)", xyseriescollection, PlotOrientation.VERTICAL,
				true, true, false);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		xyplot.setDomainPannable(true);
		xyplot.setBackgroundPaint(new Color(255,255,255));//배경색을 설정 한다. 
		
		XYStepAreaRenderer xysteparearenderer = new XYStepAreaRenderer(2);	
		//영역의 색을 변경한다. 흑백에 맞게
		/*xysteparearenderer.setSeriesPaint(0, new Color(0,0,0));
		xysteparearenderer.setSeriesPaint(1, new Color(30,30,30));
		xysteparearenderer.setSeriesPaint(2, new Color(60,60,60));
		xysteparearenderer.setSeriesPaint(3, new Color(90,90,90));
		xysteparearenderer.setSeriesPaint(4, new Color(120,120,120));
		xysteparearenderer.setSeriesPaint(5, new Color(150,150,150));*/
		
		xysteparearenderer.setDataBoundsIncludesVisibleSeriesOnly(false);
		xysteparearenderer
				.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		xysteparearenderer.setDefaultEntityRadius(6);
		xyplot.setRenderer(xysteparearenderer);

		ChartPanel chartPanel = new ChartPanel(jfreechart);

		JFrame f = new JFrame("StackedXYAreaRenderer");
		f.setSize(600, 600);
		f.getContentPane().add(chartPanel);

		// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	// 파이 그래프를 그리는 메소드 이다.
	public void PieGraphGenerate(String[] arGrop, double[] arValue,
			String arTitle, String arSubTitle) {
		// 데이터를 설정해 주는 부분이다.
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue(arGrop[0], arValue[0]);	//CPU
		data.setValue(arGrop[1], arValue[1]);	//WIFI
		data.setValue(arGrop[5], arValue[5]);	//3G
		data.setValue(arGrop[2], arValue[2]);	//LED
		data.setValue(arGrop[3], arValue[3]);	//GPS
		data.setValue(arGrop[4], arValue[4]);	//AUDIO
		
		//offset data를 선언한다.
		RectangleInsets pieOffset = new RectangleInsets(50.0, 50.0, 50.0, 50.0);

		// 차트 객체를 설정하는 부분이다.
		JFreeChart chart = ChartFactory.createPieChart(arTitle, data, true,
				true, false);
		TextTitle subTitle = new TextTitle(arSubTitle);
		chart.setBackgroundPaint(Color.WHITE);
		chart.addSubtitle(subTitle);
		PiePlot pieplot = (PiePlot) chart.getPlot();
		pieplot.setNoDataMessage("No data available");
		pieplot.setExplodePercent("LED", 0.20000000000000001D);
		pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0} ({1} mW) ({2} percent)"));
		pieplot.setLabelBackgroundPaint(new Color(220, 220, 220));
		pieplot
				.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator(
						"Tooltip for legend item {0}"));
		//흑백 처리
		/*pieplot.setSectionPaint(arGrop[0], new Color(0,0,0));
		pieplot.setSectionPaint(arGrop[1], new Color(60,60,60));
		pieplot.setSectionPaint(arGrop[2], new Color(120,120,120));
		pieplot.setSectionPaint(arGrop[4], new Color(180,180,180));*/
		
		//pieplot.setSimpleLabels(true);
		//pieplot.setSimpleLabelOffset(pieOffset);	//라벨의 offset을 결정한다.
		
		pieplot.setInteriorGap(0.0D);

		// 패널을 만들어 주는 부분이다.
		ChartPanel chartPanel = new ChartPanel(chart);
		JFrame f = new JFrame("");
		f.setSize(600, 600);
		f.getContentPane().add(chartPanel);

		// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	// 해당 기능에 라인그래프를 그려주는 메소드 이다.
	public void LineGraphGenerate(ArrayList<Integer> arList, String arTitle,
			String arSubTitle, String arLineName) {

		// 라인의 이름을 설정한다.
		XYSeries series = new XYSeries(arLineName);
		for (int i = 0; i < arList.size(); i++) {
			// 추출한 전력값을 노드에 하나하나 대입한다.
			series.add(i, arList.get(i));
		}
		// 대입한 노드를 하나의 집합으로 만든다.
		XYDataset dataset = new XYSeriesCollection(series);

		// 정보를 바탕으로 차트객체를 생성한다.
		JFreeChart chart = ChartFactory.createXYLineChart(arTitle, "Time(sec)",
				"Power(mW)", dataset,
				org.jfree.chart.plot.PlotOrientation.VERTICAL, true, true,
				false);

		TextTitle subTitle = new TextTitle(arSubTitle);

		chart.setBackgroundPaint(Color.WHITE);
		chart.addSubtitle(subTitle);

		ChartPanel chartPanel = new ChartPanel(chart);

		JFrame f = new JFrame("Power consumption chart");
		f.setSize(600, 600);
		f.getContentPane().add(chartPanel);
		// 창이 모두 다치기 때문에 close 명력을 제거한다.
		// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	// 컴포넌트의 상태를 변경 시켜주는 메소드 이다.
	public void ComponetStateChanger(int mode) {
		if (mode == POWER_BUTTON_OFF) {
			mTotalPowerBtn.setEnabled(false);
			mBatteryCapacityBtn.setEnabled(false);
			mCpuBtn.setEnabled(false);
			mWifiBtn.setEnabled(false);
			mLedBtn.setEnabled(false);
			mGpsBtn.setEnabled(false);
			mAudioBtn.setEnabled(false);
			mAppTotalPowerBtn.setEnabled(false);
			
			mDevicesPowerButton.setEnabled(false);
			mAppStackedPower.setEnabled(false);
			m3GBtn.setEnabled(false);
			mComponentLEDBtn.setEnabled(false);
			mComponentWIFIBtn.setEnabled(false);
			mComponentThreeGBtn.setEnabled(false);
			mComponentCPUBtn.setEnabled(false);
			
		} else if (mode == POWER_BUTTON_ON) {
			mTotalPowerBtn.setEnabled(true);
			mBatteryCapacityBtn.setEnabled(true);
			mCpuBtn.setEnabled(true);
			mWifiBtn.setEnabled(true);
			mLedBtn.setEnabled(true);
			mGpsBtn.setEnabled(true);
			mAudioBtn.setEnabled(true);
			mAppTotalPowerBtn.setEnabled(true);
			
			mDevicesPowerButton.setEnabled(true);
			mAppStackedPower.setEnabled(true);
			m3GBtn.setEnabled(true);
			mComponentLEDBtn.setEnabled(true);
			mComponentWIFIBtn.setEnabled(true);
			mComponentThreeGBtn.setEnabled(true);
			mComponentCPUBtn.setEnabled(true);
		}
	}

}

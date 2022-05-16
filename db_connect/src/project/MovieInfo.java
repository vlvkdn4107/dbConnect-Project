package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import lombok.Data;

@Data
public class MovieInfo extends JFrame implements ItemListener {

	MovieInfoDao dao = new MovieInfoDao();

	// 카테고리 검색
	private JPanel searchPanel;
	private JPanel searchPanel2;
	private TitledBorder categoryBorder;
	private TitledBorder categoryBorder2;

	// crud
	private JPanel crudPanel;
	private JPanel crudPanel2;
//	private TitledBorder crudBorder;

	private JTabbedPane jTabbedPane;
	
//	private JButton createButton;
//	private JButton updateButton;
//	private JButton deleteButton;

	private JLabel optionLabel;
	private JLabel optionLabel2;
	
	private JRadioButton movieName;
	private JRadioButton actorName;
	private JRadioButton releasedDate;
	private JRadioButton birthYear;

	private JTextField movieNameField;
	private JTextField actorNameField;
	private JTextField releasedDateField;
	private JTextField birthYearField;

	private JButton movieNameButton;
	private JButton actorNameButton;
	private JButton releasedDateButton;
	private JButton birthYearButton;

	private JComboBox comboBox;
	private JComboBox comboBox2;

	private JButton confirmBotton;
	private JButton confirmBotton2;
	
	// 영화 조회
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel mainPanel;
	
	// 배우 조회
	private JTable table2;
	private DefaultTableModel model2;
	private JScrollPane scrollPane2;
	private JPanel mainPanel2;

	// 영화 테이블
	String schema[] = { "번호", "이름", "개봉년도", "수익", "관객수", "스크린 수", "평점" };
	
	// 배우 테이블
	String schema2[] = { "배우번호", "이름", "출생년도", "키", "몸무게", "배우자"};

	public MovieInfo() {

		setBounds(100, 100, 628, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 메인 패널
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(null);

		// 카테고리로 검색
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		categoryBorder = new TitledBorder("카테고리 검색");
		searchPanel.setBorder(categoryBorder);
		searchPanel.setBounds(10, 80, 592, 105);
		mainPanel.add(searchPanel);

		//
		crudPanel = new JPanel();
		crudPanel2 = new JPanel();
		crudPanel.setLayout(null);
		crudPanel2.setLayout(null);

		optionLabel = new JLabel("옵션을 선택하세요");
		optionLabel.setBounds(180, 3, 200, 30);
		crudPanel.add(optionLabel);
		optionLabel2 = new JLabel("옵션을 선택하세요");
		optionLabel2.setBounds(180, 3, 200, 30);
		crudPanel2.add(optionLabel2);
		
		confirmBotton = new JButton("확인");
		confirmBotton.setBounds(410, 8, 70, 20);
		crudPanel.add(confirmBotton);
		confirmBotton2 = new JButton("확인");
		confirmBotton2.setBounds(410, 8, 70, 20);
		crudPanel2.add(confirmBotton2);
		
		
		jTabbedPane = new JTabbedPane();
		jTabbedPane.setBounds(10, 10, 592, 65);
		jTabbedPane.setTabPlacement(JTabbedPane.TOP);
		jTabbedPane.addTab("영화정보", crudPanel);
		jTabbedPane.addTab("배우정보", crudPanel2);
		
		
		mainPanel.add(jTabbedPane);
		
		
		model = new DefaultTableModel(null, schema);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 200, 588,330);
		scrollPane.setViewportView(table);
		mainPanel.add(scrollPane);

		// 라디오 박스
		movieName = new JRadioButton("이름");
		movieName.setBounds(80, 27, 50, 12);
		searchPanel.add(movieName);
		
		actorName = new JRadioButton("이름");
		actorName.setBounds(80, 27, 50, 12);
		searchPanel.add(actorName);

		releasedDate = new JRadioButton("개봉일");
		releasedDate.setBounds(80, 67, 70, 12);
		searchPanel.add(releasedDate);
		
		birthYear = new JRadioButton("출생년도");
		birthYear.setBounds(80, 67, 70, 12);
		searchPanel.add(birthYear);

		movieNameField = new JTextField("명량");
		movieNameField.setBounds(180, 20, 230, 26);
		searchPanel.add(movieNameField);
		
		actorNameField = new JTextField("최민식");
		actorNameField.setBounds(180, 20, 230, 26);
		searchPanel.add(actorNameField);

		releasedDateField = new JTextField("2014");
		releasedDateField.setBounds(180, 60, 230, 26);
		searchPanel.add(releasedDateField);
		
		birthYearField = new JTextField("1970");
		birthYearField.setBounds(180, 60, 230, 26);
		searchPanel.add(birthYearField);
		
		movieNameButton = new JButton("검색");
		movieNameButton.setBounds(440, 20, 65, 25);
		searchPanel.add(movieNameButton);
		
		actorNameButton = new JButton("검색");
		actorNameButton.setBounds(440, 20, 65, 25);
		searchPanel.add(actorNameButton);
		
		releasedDateButton = new JButton("검색");
		releasedDateButton.setBounds(440, 60, 65, 25);
		searchPanel.add(releasedDateButton);
		
		birthYearButton = new JButton("검색");
		birthYearButton.setBounds(440, 60, 65, 25);
		searchPanel.add(birthYearButton);
		
//		searchButton.addActionListener(this);
//        releaseDate.addActionListener(this);

		movieName.addItemListener(this);
		releasedDate.addItemListener(this);

		actorName.addItemListener(this);
		birthYear.addItemListener(this);
		
		movieNameField.setEnabled(false);
		releasedDateField.setEnabled(false);
		movieNameButton.setEnabled(false);
		releasedDateButton.setEnabled(false);	
		
		actorNameField.setEnabled(false);
		birthYearField.setEnabled(false);
		actorNameButton.setEnabled(false);
		birthYearButton.setEnabled(false);	
		
		
		
		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel columnModel = table.getColumnModel();

		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setCellRenderer(defaultTableCellRenderer);
		}

		SelectAll();

        comboBox = new JComboBox();
        comboBox.setBounds(300, 8, 70, 20);
        crudPanel.add(comboBox);
        
        comboBox2 = new JComboBox();
        comboBox2.setBounds(300, 8, 70, 20);
        crudPanel2.add(comboBox2);
        
//        comboBox.addItem("선택");
        comboBox.addItem("생성");
        comboBox.addItem("수정");
        comboBox.addItem("삭제");
        
        comboBox2.addItem("생성");
        comboBox2.addItem("수정");
        comboBox2.addItem("삭제");

        confirmBotton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					new CreatePanel();
				} else if(comboBox.getSelectedIndex() == 1) {
					new UpdatePanel();
				} else if(comboBox.getSelectedIndex() == 2) {
					new DeletePanel();
				}
			}
		});
        
        setLocationRelativeTo(null);
		setVisible(true);

	}

	public void SelectAll() {
		
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}
		
		for (int i = 0; i < dao.selectAll().size(); i++) {
			model.addRow(new Object[] { dao.selectAll().get(i).getMovieNumber(), dao.selectAll().get(i).getMovieName(),
					dao.selectAll().get(i).getReleasedDate(), dao.selectAll().get(i).getRevenue(),
					dao.selectAll().get(i).getAudience(), dao.selectAll().get(i).getScreen(),
					dao.selectAll().get(i).getStarRating() });
		}
	}

	// 라디오 버튼
	@Override
	public void itemStateChanged(ItemEvent e1) {

		// 영화 제목 버튼 클릭됨
		if (e1.getSource() == movieName) {
			movieNameField.setEnabled(true);
			movieNameButton.setEnabled(true);
			releasedDate.setEnabled(false);
			// 영화 쿼리 뿌림

			movieNameButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == movieNameButton) {
						dao.selectByMovieName(movieNameField.getText());

						if (model.getRowCount() > 0) {
							for (int i = model.getRowCount() - 1; i > -1; i--) {
								model.removeRow(i);
							}
						}

						for (int i = 0; i < dao.selectByMovieName(movieNameField.getText()).size(); i++) {
							System.out.println("영화제목");
							model.addRow(new Object[] {
									dao.selectByMovieName(movieNameField.getText()).get(i).getMovieNumber(),
									dao.selectByMovieName(movieNameField.getText()).get(i).getMovieName(),
									dao.selectByMovieName(movieNameField.getText()).get(i).getReleasedDate(),
									dao.selectByMovieName(movieNameField.getText()).get(i).getRevenue(),
									dao.selectByMovieName(movieNameField.getText()).get(i).getAudience(),
									dao.selectByMovieName(movieNameField.getText()).get(i).getScreen(),
									dao.selectByMovieName(movieNameField.getText()).get(i).getStarRating() });
						}
					}
				}
			});

			if (e1.getStateChange() == ItemEvent.DESELECTED) {
				movieNameField.setEnabled(false);
				movieNameButton.setEnabled(false);
				releasedDate.setEnabled(true);
				SelectAll();
			}
		} else if (e1.getSource() == releasedDate) {
			releasedDateField.setEnabled(true);
			releasedDateButton.setEnabled(true);
			movieName.setEnabled(false);

			releasedDateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == releasedDateButton) {
						dao.selectByReleasedYear(releasedDateField.getText());

						if (model.getRowCount() > 0) {
							for (int i = model.getRowCount() - 1; i > -1; i--) {
								model.removeRow(i);
							}
						}

						for (int i = 0; i < dao.selectByReleasedYear(releasedDateField.getText()).size(); i++) {
							System.out.println("개봉일");
							model.addRow(new Object[] {
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getMovieNumber(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getMovieName(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getReleasedDate(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getRevenue(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getAudience(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getScreen(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getStarRating() });
						}
					}
				}
			});

			if (e1.getStateChange() == ItemEvent.DESELECTED) {
				releasedDateField.setEnabled(false);
				releasedDateButton.setEnabled(false);
				movieName.setEnabled(true);
				SelectAll();
			}
		}
		
		
		
		
	}
	
	// 내부 클래스
	class CreatePanel extends JFrame {
		
		JPanel panel;

		JLabel label;
		
		
		JTextField movieNumberField;
		JTextField movieNameField;
		JTextField releasedDateField;
		JTextField revenueField;
		JTextField audienceField;
		JTextField screenField;
		JTextField starRatingField;
		
		JLabel movieNumberLabel;
		JLabel movieNameLabel;
		JLabel releasedDateLabel;
		JLabel revenueLabel;
		JLabel audienceLabel;
		JLabel screenLabel;
		JLabel starRatingLabel;
		
		JButton confirmButton;
		
		MovieInfoDto dto;
		
		
		public CreatePanel() {
			
			setBounds(600, 600, 600, 600);
			
			panel = new JPanel();
			setContentPane(panel);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setLayout(null);
			
			label = new JLabel("추가하기");
			label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			label.setBounds(280, 40, 500, 30);
			panel.add(label);
			
			movieNumberLabel = new JLabel("영화번호");
			movieNumberLabel.setBounds(160, 100, 50, 30);
			panel.add(movieNumberLabel);
			
			movieNumberField = new JTextField("123");
			movieNumberField.setBounds(240, 100, 200, 30);
			panel.add(movieNumberField);
			
			movieNameLabel = new JLabel("영화제목");
			movieNameLabel.setBounds(160, 150, 50, 30);
			panel.add(movieNameLabel);
			
			movieNameField = new JTextField("명량");
			movieNameField.setBounds(240, 150, 200, 30);
			panel.add(movieNameField);
			
			
			releasedDateLabel = new JLabel("개봉일");
			releasedDateLabel.setBounds(160, 200, 50, 30);
			panel.add(releasedDateLabel);
			
			releasedDateField = new JTextField("1995-02-02");
			releasedDateField.setBounds(240, 200, 200, 30);
			panel.add(releasedDateField);
			
			revenueLabel = new JLabel("수익금");
			revenueLabel.setBounds(160, 250, 50, 30);
			panel.add(revenueLabel);
			
			revenueField = new JTextField("12341234");
			revenueField.setBounds(240, 250, 200, 30);
			panel.add(revenueField);
			
			audienceLabel = new JLabel("관객 수");
			audienceLabel.setBounds(160, 300, 50, 30);
			panel.add(audienceLabel);
			
			audienceField = new JTextField("123123");
			audienceField.setBounds(240, 300, 200, 30);
			panel.add(audienceField);
			
			screenLabel = new JLabel("스크린 수");
			screenLabel.setBounds(160, 350, 60, 30);
			panel.add(screenLabel);
			
			screenField = new JTextField("1234234");
			screenField.setBounds(240, 350, 200, 30);
			panel.add(screenField);
			
			starRatingLabel = new JLabel("평점");
			starRatingLabel.setBounds(160, 400, 50, 30);
			panel.add(starRatingLabel);
			
			starRatingField = new JTextField("1");
			starRatingField.setBounds(240, 400, 200, 30);
			panel.add(starRatingField);
			
			confirmButton = new JButton("확인");
			confirmButton.setBounds(280, 460, 100, 30);
			panel.add(confirmButton);
			
			setLocationRelativeTo(null);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			
		
			
			confirmButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					dto = new MovieInfoDto(Integer.parseInt(movieNumberField.getText()), movieNameField.getText(),
							releasedDateField.getText(), Long.parseLong(revenueField.getText()), Long.parseLong(audienceField.getText()),
							Integer.parseInt(screenField.getText()), Float.parseFloat(starRatingField.getText()));
					
					
					System.out.println("추가 버튼");
					dao.insertData(dto);
					
					
//					if (model.getRowCount() > 0) {
//						for (int i = model.getRowCount() - 1; i > -1; i--) {
//							model.removeRow(i);
//						}
//					}
					
					SelectAll();
					
					setVisible(false);
					
				}
			});
			
		}
	
	
	}
	
	class DeletePanel {
		
		public DeletePanel() {
			
			String movieName = JOptionPane.showInputDialog(null, "삭제할 영화 제목을 입력하세요", null);
			dao.deleteData(movieName);
			
			
			SelectAll();
			
			
		}
		
	}

	class UpdatePanel extends JFrame{
		
		JPanel panel;

		JLabel label;
		
		
		JTextField movieNumberField;
		JTextField movieNameField;
		JTextField releasedDateField;
		JTextField revenueField;
		JTextField audienceField;
		JTextField screenField;
		JTextField starRatingField;
		
		JLabel movieNumberLabel;
		JLabel movieNameLabel;
		JLabel releasedDateLabel;
		JLabel revenueLabel;
		JLabel audienceLabel;
		JLabel screenLabel;
		JLabel starRatingLabel;
		
		JButton confirmButton;
		
		MovieInfoDto dto;
		
		
		public UpdatePanel()  {
			
			
			setBounds(600, 600, 600, 600);
			
			panel = new JPanel();
			setContentPane(panel);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setLayout(null);
			
			label = new JLabel("수정하기");
			label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			label.setBounds(280, 40, 500, 30);
			panel.add(label);
			
			movieNumberLabel = new JLabel("영화번호");
			movieNumberLabel.setBounds(160, 100, 50, 30);
			panel.add(movieNumberLabel);
			
			movieNumberField = new JTextField("");
			movieNumberField.setBounds(240, 100, 200, 30);
			panel.add(movieNumberField);
			
			movieNameLabel = new JLabel("영화제목");
			movieNameLabel.setBounds(160, 150, 50, 30);
			panel.add(movieNameLabel);
			
			movieNameField = new JTextField("");
			movieNameField.setBounds(240, 150, 200, 30);
			panel.add(movieNameField);
			
			
			releasedDateLabel = new JLabel("개봉일");
			releasedDateLabel.setBounds(160, 200, 50, 30);
			panel.add(releasedDateLabel);
			
			releasedDateField = new JTextField("");
			releasedDateField.setBounds(240, 200, 200, 30);
			panel.add(releasedDateField);
			
			revenueLabel = new JLabel("수익금");
			revenueLabel.setBounds(160, 250, 50, 30);
			panel.add(revenueLabel);
			
			revenueField = new JTextField("");
			revenueField.setBounds(240, 250, 200, 30);
			panel.add(revenueField);
			
			audienceLabel = new JLabel("관객 수");
			audienceLabel.setBounds(160, 300, 50, 30);
			panel.add(audienceLabel);
			
			audienceField = new JTextField("");
			audienceField.setBounds(240, 300, 200, 30);
			panel.add(audienceField);
			
			screenLabel = new JLabel("스크린 수");
			screenLabel.setBounds(160, 350, 60, 30);
			panel.add(screenLabel);
			
			screenField = new JTextField("");
			screenField.setBounds(240, 350, 200, 30);
			panel.add(screenField);
			
			starRatingLabel = new JLabel("평점");
			starRatingLabel.setBounds(160, 400, 50, 30);
			panel.add(starRatingLabel);
			
			starRatingField = new JTextField("");
			starRatingField.setBounds(240, 400, 200, 30);
			panel.add(starRatingField);
			
			confirmButton = new JButton("확인");
			confirmButton.setBounds(280, 460, 100, 30);
			panel.add(confirmButton);
			
			setLocationRelativeTo(null);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
			
		
			String movieName = JOptionPane.showInputDialog(null, "수정할 영화 제목을 입력하세요", null, JOptionPane.OK_CANCEL_OPTION);
			
			if((movieName != null) && (movieName.length() > 0)) {
				for(int j = 0; j < model.getRowCount(); j++) {
					for(int i = 0; i < model.getColumnCount(); i++) {
						if(model.getValueAt(j, i).equals(movieName)) {
							movieNumberField.setText(String.valueOf(model.getValueAt(j, 0)));
							movieNameField.setText(String.valueOf(model.getValueAt(j, 1)));
							releasedDateField.setText(String.valueOf(model.getValueAt(j, 2)));
							revenueField.setText(String.valueOf(model.getValueAt(j, 3)));
							audienceField.setText(String.valueOf(model.getValueAt(j, 4)));
							screenField.setText(String.valueOf(model.getValueAt(j, 5)));
							starRatingField.setText(String.valueOf(model.getValueAt(j, 6)));
						}
						
					}
				}
				
			}
			
			
//			if((movieName != null) && (movieName.length() > 0)) {
//						if(model.getValueAt(j, i).equals(movieName)) {
//							movieNumberField.setText(String.valueOf(model.getValueAt(j, 0)));
//							movieNameField.setText(String.valueOf(model.getValueAt(j, 1)));
//							releasedDateField.setText(String.valueOf(model.getValueAt(j, 2)));
//							revenueField.setText(String.valueOf(model.getValueAt(j, 3)));
//							audienceField.setText(String.valueOf(model.getValueAt(j, 4)));
//							screenField.setText(String.valueOf(model.getValueAt(j, 5)));
//							starRatingField.setText(String.valueOf(model.getValueAt(j, 6)));
//							break;
//						}
//						
//				
//			}
			
			
			confirmButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					System.out.println("수정 버튼");
					
//					int temp1 = Integer.parseInt(movieNumberField.getText());
//					String temp2  = movieNameField.getText();
//					String temp3  = releasedDateField.getText();
//					long temp4 = Long.parseLong(revenueField.getText());
//					long temp5 = Long.parseLong(audienceField.getText());
//					int temp6 = Integer.parseInt(screenField.getText());
//					float temp7 = Float.parseFloat(starRatingField.getText());
					
					
//					movieNumberField.setText(temp1 + "");
//					movieNameField.setText(temp2);
//					releasedDateField.setText(temp3);
//					revenueField.setText(temp4 + "");
//					audienceField.setText(temp5 + "");
//					screenField.setText(temp6 + "");
//					starRatingField.setText(temp7 + "");
					
					dao.updateData(Integer.parseInt(movieNumberField.getText()), 
							movieNameField.getText(), 
							releasedDateField.getText(),
							Long.parseLong(revenueField.getText()), 
							Long.parseLong(audienceField.getText()), 
							Integer.parseInt(screenField.getText()), 
							Float.parseFloat(starRatingField.getText()), movieName);
					
					SelectAll();
					
					setVisible(false);
					
				}
			});
		}
		
	}	
	
	
	
}
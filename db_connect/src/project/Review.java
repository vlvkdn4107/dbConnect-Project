package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import lombok.Data;

@Data
public class Review extends JFrame {

	MovieInfoDao dao;

	private JTextArea textArea;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField3;
	private JPanel jPanel;
	private JLabel jLabel;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton btn;

	// 영화 조회
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	// 영화 테이블
	String schema[] = { "번호", "이름", "개봉년도", "관객수", "평점" };

	public Review() {

		dao = new MovieInfoDao();

		setTitle("평점/리뷰 작성 페이지 입니다");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 960);
		setLocationRelativeTo(null);

		model = new DefaultTableModel(null, schema);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 153, 588, 313);
		scrollPane.setViewportView(table);

		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel columnModel = table.getColumnModel();

		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setCellRenderer(defaultTableCellRenderer);
		}

		SelectAll();
		jPanel = new JPanel();
		jLabel3 = new JLabel("닉네임");
		textField3 = new JTextField(5);
		jLabel = new JLabel("영화");
		textField1 = new JTextField(20);
		jLabel1 = new JLabel("평점");
		textField = new JTextField(" /10", 5);
		jLabel2 = new JLabel("영화리뷰");
		textArea = new JTextArea("영화리뷰를 남겨주세요", 25, 40);
		btn = new JButton("저장");

		setVisible(true);
		jPanel.add(scrollPane);
		jPanel.add(jLabel3);
		jPanel.add(textField3);
		jPanel.add(jLabel);
		jPanel.add(textField1);
		jPanel.add(jLabel1);
		jPanel.add(textField);
		jPanel.add(jLabel2);
		jPanel.add(textArea);
		jPanel.add(btn);

		add(jPanel, FlowLayout.LEFT);

		setEventListener();
	}

	private void SelectAll() {
		for (int i = 0; i < dao.selectAll().size(); i++) {
			model.addRow(new Object[] { dao.selectAll().get(i).getMovieNumber(), dao.selectAll().get(i).getMovieName(),
					dao.selectAll().get(i).getReleasedDate(), dao.selectAll().get(i).getAudience(),
					dao.selectAll().get(i).getStarRating() });
		}
	}

	private void setEventListener() {
		btn.addActionListener(new ActionListener() {

			// 저장 버튼 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// System.out.println("평점 / 리뷰 저장완료");
//				ReviewDao rd = new ReviewDao();
//				ReviewList reviewList = new ReviewList();

				System.out.println(textArea.getText());
//
//				Calendar calendar = Calendar.getInstance();
//				DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
//				String date = dateFormat.format(calendar.getTimeInMillis());
//
				String text = textArea.getText();
				String fileName = textField3.getText() + "의 "+ textField1.getText() + " 리뷰";
//				// 버퍼는 자기 공간이 다 채워지면 자동으로 전달한다
//
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)); // 임시창고 buffer
					bw.write(text);
					bw.flush(); // 강제집행
					bw.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	}

	public static void main(String[] args) {
		new Review();
	}
}
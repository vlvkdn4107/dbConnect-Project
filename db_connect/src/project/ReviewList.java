package project;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ReviewList extends JFrame{

	ReviewDao dao;
	
	private JPanel jPanel;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	
	String schema[] = {"닉네임", "영화번호", "영화이름", "평점", "리뷰"};
	
	public ReviewList() {
		
		dao = new ReviewDao();
		
		setTitle("영화시청자 평점 리스트");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,500);
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
		
		jPanel = new JPanel();
		
		setVisible(true);
		jPanel.add(scrollPane);
		
		add(jPanel, FlowLayout.LEFT);
		
		selectAll();
	}

	// 리뷰번호는 잘 들어옴
	private void selectAll() {
		for (int i = 0; i < dao.selectAll().size(); i++) {
			model.addRow(new Object[] { i + 1, dao.selectAll().get(i).getNickname(),
					dao.selectAll().get(i).getMovieNumber(), dao.selectAll().get(i).getMovieName(),
					dao.selectAll().get(i).getReleasedDate(), dao.selectAll().get(i).getAudience(),
					dao.selectAll().get(i).getStarRating(), dao.selectAll().get(i).getReview() });
		}
	}
	
	public static void main(String[] args) {
		new ReviewList();
	}
}
package ch03;

import java.util.ArrayList;

public interface IShopDb {

	// userTbl, buyTbl 결과 *
	ArrayList<ShopDbDto> innerJoin1();
	
	// userTbl, buyTbl null 제거, 결과 *
	ArrayList<ShopDbDto> leftJoin1();
	
	// buyTbl, userTbl, 결과 *
	void leftJoin2();

	// 이순신, 김유신(전화번호, 주소)
	ArrayList<ShopDbDto> buyInfo(String UserName);
	
	
}

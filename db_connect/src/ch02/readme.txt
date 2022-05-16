
executeQuery와 executeUpdate의 차이점
executeQuery는 resultSet을 만드는 sql문에서 사용합니다.
주로 SELECT 문을 수행할 때 사용됩니다.

executeQuery는 Insert나 UPDATE와 같은 쿼리문에서 사용됩니다.



Can not issue data manipulation statements with executeQuery().
update, insert, delete, 문을 사용할 때 executeUpdate()로 전송하지 않았을 경우 발생한다.

exexuteUpdate() 리턴값은 쿼리를 전송해서 변화한 행의 갯수를 나타낸다.
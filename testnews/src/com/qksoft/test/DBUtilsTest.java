package com.qksoft.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryLoader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.qksoft.entity.Customer;
import com.qksoft.util.JdbcUtil;

/**
 * 测试 DBUtils 工具类
 *
 */
public class DBUtilsTest {

	 
	
	/**
	 * 1. ResultSetHandler 的作用: QueryRunner 的 query 方法的返回值最终取决于
	 * query 方法的 ResultHandler 参数的 hanlde 方法的返回值. 
	 * 
	 * 2. BeanListHandler: 把结果集转为一个 Bean 的 List, 并返回. Bean 的类型在
	 * 创建 BeanListHanlder 对象时以 Class 对象的方式传入. 可以适应列的别名来映射 
	 * JavaBean 的属性名: 
	 * String sql = "SELECT id, name customerName, email, birth " +
	 *			"FROM customers WHERE id = ?";
	 * 
	 * BeanListHandler(Class<T> type)
	 * 
	 * 3. BeanHandler: 把结果集转为一个 Bean, 并返回. Bean 的类型在创建 BeanHandler
	 * 对象时以 Class 对象的方式传入
	 * BeanHandler(Class<T> type) 
	 * 
	 * 4. MapHandler: 把结果集转为一个 Map 对象, 并返回. 若结果集中有多条记录, 仅返回
	 * 第一条记录对应的 Map 对象. Map 的键: 列名(而非列的别名), 值: 列的值
	 * 
	 * 5. MapListHandler: 把结果集转为一个 Map 对象的集合, 并返回. 
	 * Map 的键: 列名(而非列的别名), 值: 列的值
	 * 
	 * 6. ScalarHandler: 可以返回指定列的一个值或返回一个统计函数的值. 
	 */
	
	public void testScalarHandler(){
		Connection connection = null;
		QueryRunner queryRunner = new QueryRunner();
		
		String sql = "SELECT name FROM customers " +
				"WHERE id = ?";
		
		try {
			connection = JdbcUtil.getConnection();
			Object count = queryRunner.query(connection, sql, 
					new ScalarHandler(), 4);
			
			System.out.println(count); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeResources(connection, null, null);
		}
	}
	
	public void testMapListHandler(){
		Connection connection = null;
		QueryRunner queryRunner = new QueryRunner();
		
		String sql = "SELECT id, name, email, birth " +
				"FROM customers";
		
		try {
			connection = JdbcUtil.getConnection();
			List<Map<String, Object>> mapList = queryRunner.query(connection, 
					sql, new MapListHandler());
			
			System.out.println(mapList); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeResources(connection, null, null);
		}
	}
	
	public void testMapHandler(){
		Connection connection = null;
		QueryRunner queryRunner = new QueryRunner();
		
		String sql = "SELECT id, name customerName, email, birth " +
				"FROM customers WHERE id = ?";
		
		try {
			connection = JdbcUtil.getConnection();
			Map<String, Object> map = queryRunner.query(connection, 
					sql, new MapHandler(), 2);
			
			System.out.println(map); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeResources(connection, null, null);
		}
	}
	
	/**
	 * 测试 ResultSetHandler 的 BeanListHandler 实现类
	 * BeanListHandler: 把结果集转为一个 Bean 的 List. 该 Bean
	 * 的类型在创建 BeanListHandler 对象时传入:
	 * 
	 * new BeanListHandler<>(Customer.class)
	 * 
	 */
	public void testBeanListHandler(){
		String sql = "SELECT id, name customerName, email, birth " +
				"FROM customers";
		
		//1. 创建 QueryRunner 对象
		QueryRunner queryRunner = new QueryRunner();
		
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			
			Object object = queryRunner.query(conn, sql, 
					new BeanListHandler<>(Customer.class)); 			
			
			System.out.println(object); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeResources(conn, null, null);
		}
	}
	public void testBeanHandler(){
		String sql = "SELECT id, name customerName, email, birth " +
				"FROM customers where id=?";
		
		//1. 创建 QueryRunner 对象
		QueryRunner queryRunner = new QueryRunner();
		
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			
			Object object = queryRunner.query(conn, sql, 4,
					new BeanHandler<>(Customer.class)); 			
			
			System.out.println(object); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeResources(conn, null, null);
		}
	}

	/**
	 * 测试 QueryRunner 的 query 方法
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testResultSetHandler(){
		String sql = "SELECT id, name, email, birth " +
				"FROM customers";
		
		//1. 创建 QueryRunner 对象
		QueryRunner queryRunner = new QueryRunner();
		
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			/**
			 * 2. 调用 query 方法:
			 * ResultSetHandler 参数的作用: query 方法的返回值直接取决于 
			 * ResultSetHandler 的 hanlde(ResultSet rs) 是如何实现的. 实际上, 在
			 * QueryRunner 类的 query 方法中也是调用了 ResultSetHandler 的 handle()
			 * 方法作为返回值的。
			 */
			Object object = queryRunner.query(conn, sql, 
					new ResultSetHandler(){
						@Override
						public Object handle(ResultSet rs) throws SQLException {
							List<Customer> customers = new ArrayList<>();
							
							while(rs.next()){
								int id = rs.getInt(1);
								String name = rs.getString(2);
								String email = rs.getString(3);
								Date birth = rs.getDate(4);
								
								Customer customer = 
										new Customer(id, name, email, birth);
								customers.add(customer);
							}
							
							return customers;
						}
					}
			
					);			
			
			System.out.println(object); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeResources(conn, null, null);
		}
		
	}
	
	/**
	 * 测试 QueryRunner 类的 update 方法
	 * 该方法可用于 INSERT, UPDATE 和 DELETE
	 */
	public void testQueryRunnerUpdate() {
		//1. 创建 QueryRunner 的实现类
		QueryRunner queryRunner = new QueryRunner();
		
		String sql = "insert into customers(name,email) values(?,?) ";
		
		Connection connection = null;
		
		try {
			connection = JdbcUtil.getConnection();
			//2. 使用其 update 方法
			queryRunner.update(connection, 
					sql, "lisi","zhangsan@163.com");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeResources(connection, null, null);
		}
		
	}
	
	public static void main(String[] args) {
		
		DBUtilsTest dt=new DBUtilsTest();
		dt.testScalarHandler();
		
		
		
	}

}

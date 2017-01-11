package com.oneToOne;

import java.util.Date;
import java.util.EnumSet;

//import javax.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

public class TestOneToOne {
	@Test
	public void testShemaExport() {
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry)
				.buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}

	@Test
	public void addStudents() {
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure().build();
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 生成SessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		//
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		IdCard card = new IdCard("123456789000000000", "张三");
		Student student = new Student((long) 1, "男", new Date(), "计算机", card);
		session.save(card);
		session.save(student);
		try {
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

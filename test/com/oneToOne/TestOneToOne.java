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
		// ��������ע�����
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry)
				.buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}

	@Test
	public void addStudents() {
		// ��������ע�����
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure().build();
		// �������ö���
		Configuration config = new Configuration().configure();
		// ����SessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		//
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		IdCard card = new IdCard("123456789000000000", "����");
		Student student = new Student((long) 1, "��", new Date(), "�����", card);
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

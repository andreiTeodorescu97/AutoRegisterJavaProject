package com.auto.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.auto.entity.Log;

@Repository
public class LogDAOImpl implements LogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addLogToDatabase(String logType, String logMessage) {
		Session currentSession = sessionFactory.getCurrentSession();
		Log theLog = new Log();
		theLog.setType(logType);
		theLog.setMessage(logMessage);
        LocalDate localDate = LocalDate.now();
		theLog.setDateMod(localDate.toString());
		currentSession.save(theLog);
		
	}

	@Override
	public List<Log> getLogsFromDatabase() {
		Session currentSession = sessionFactory.getCurrentSession(); 
        Query<Log> theQuery = currentSession.createQuery("from Log l order by l.id desc");
        List<Log> logs = theQuery.getResultList();
        
		return logs;
	}

}

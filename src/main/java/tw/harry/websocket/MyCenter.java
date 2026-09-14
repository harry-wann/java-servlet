package tw.harry.websocket;

import java.io.IOException;
import java.util.HashSet;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

//@ServerEndpoint("/mycenter")
public class MyCenter {

	private static HashSet<Session> sessions;
	private static Session teacherSession;
	private static boolean isTeacherExists;
	
	public MyCenter() {
		if (sessions == null) {
			sessions = new HashSet<Session>();
			isTeacherExists = false;
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		if (sessions.add(session)) {
			
		}
	}
	
	@OnMessage
	public void onMessage(String msg, Session session) {
		if (!isTeacherExists && msg.contains("isTeacher")) {
			isTeacherExists = true;
			teacherSession = session;
			System.out.println("Teacher joined!");
		} else if (teacherSession == session) {
			for (Session student : sessions) {
				try {
					student.getBasicRemote().sendText(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("OnClose()");
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("OnError()");
	}
}

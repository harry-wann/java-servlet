package tw.harry.websocket;

import java.io.IOException;
import java.util.HashSet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

//@ServerEndpoint("/myserver")
public class MyServer {
	
	private static HashSet<Session> sessions; 
	
	public MyServer() {
		System.out.println("Myserver()");
		if (sessions == null) {
			sessions = new HashSet<Session>();
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		if (sessions.add(session)) {
			System.out.printf("New session come in %s\n", session.getId());
		}
	}
	
	@OnMessage
	public void onMessage(String msg, Session session) {
		System.out.println("@OnMessage()");
		for (Session clientSession : sessions) {
			try {
				clientSession.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("@OnClose()");
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("@OnError()");
	}
}

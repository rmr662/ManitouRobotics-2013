package com.github.manitourobotics.robot;

public class SocketEvent {
	public static final int ON_DATA = 0;
	public static final int ON_CONNECT = 1;
	public static final int ON_DISCONNECT = 2;
	private Socket source;
	private int id;
	private String data;
	
	public SocketEvent(Socket source, int id, String data) {
		super();
		this.source = source;
		this.id = id;
		this.data = data;
	}
	public Socket getSource() {
		return source;
	}
	public int getId() {
		return id;
	}
	public String getData() {
		return data;
	}
	
	
}

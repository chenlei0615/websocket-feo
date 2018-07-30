package com.sunlands.feo.demo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.websocket
 * @Description : websocket业务是实现层
 * @Author : chenlei
 * @Create Date : 2018年07月30日 16:13
 * ------------    --------------    ---------------------------------
 */
@Component
@ServerEndpoint(value = "/socketServer/{userid}")
public class WebSocketService {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketService.class);

    private Session session;
    private static Map<String,Session> sessionPool = new HashMap<String,Session>();
    private static Map<String,String> sessionIds = new HashMap<String,String>();

    /**
     * 用户连接时触发
     * @param session
     * @param userid
     */
    @OnOpen
    public void open(Session session,@PathParam(value="userid")String userid){
        this.session = session;
        sessionPool.put(userid, session);
        sessionIds.put(session.getId(), userid);
    }

    /**
     * 收到信息时触发
     * @param message
     */
    @OnMessage
    public void onMessage(String message){
        sendMessage(sessionIds.get(session.getId())+"<--"+message,"niezhiliang9595");
        System.out.println("发送人:"+sessionIds.get(session.getId())+"内容:"+message);
    }

    /**
     * 连接关闭触发
     */
    @OnClose
    public void onClose(){
        sessionPool.remove(sessionIds.get(session.getId()));
        sessionIds.remove(session.getId());
    }

    /**
     * 发生错误时触发
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     *信息发送的方法
     * @param message
     * @param userId
     */
    public void sendMessage(String message,String userId){
        Session s = sessionPool.get(userId);
        if(s!=null){
            try {
                s.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取当前连接数
     * @return
     */
    public int getOnlineNum(){
        if(sessionIds.values().contains("niezhiliang9595")) {

            return sessionPool.size()-1;
        }
        return sessionPool.size();
    }

    /**
     * 获取在线用户名以逗号隔开
     * @return
     */
    public String getOnlineUsers(){
        StringBuffer users = new StringBuffer();
        /**niezhiliang9595是服务端自己的连接，不能算在线人数*/
        for (String key : sessionIds.keySet()) {
            if (!"niezhiliang9595".equals(sessionIds.get(key)))
            {
                users.append(sessionIds.get(key)+",");
            }
        }
        return users.toString();
    }

    /**
     * 信息群发
     * @param msg
     */
    public void sendAll(String msg) {
        for (String key : sessionIds.keySet()) {
            if (!"niezhiliang9595".equals(sessionIds.get(key)))
            {
                sendMessage(msg, sessionIds.get(key));
            }
        }
    }

    /**
     * 多个人发送给指定的几个用户
     * @param msg
     * @param persons  用户s
     */

    public void SendMany(String msg,String [] persons) {
        for (String userid : persons) {
            sendMessage(msg, userid);
        }

    }
}

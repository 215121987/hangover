package com.hangover.java.exception;

import com.rabbitmq.client.*;

/**
 * Created by IntelliJ IDEA.
 * User: ashifqureshi
 * Date: 09/08/15
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class RPCExceptionHandler implements ExceptionHandler {
    @Override
    public void handleUnexpectedConnectionDriverException(Connection connection, Throwable throwable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleReturnListenerException(Channel channel, Throwable throwable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleFlowListenerException(Channel channel, Throwable throwable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleConfirmListenerException(Channel channel, Throwable throwable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleBlockedListenerException(Connection connection, Throwable throwable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleConsumerException(Channel channel, Throwable throwable, Consumer consumer, String s, String s1) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleConnectionRecoveryException(Connection connection, Throwable throwable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleChannelRecoveryException(Channel channel, Throwable throwable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleTopologyRecoveryException(Connection connection, Channel channel, TopologyRecoveryException e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

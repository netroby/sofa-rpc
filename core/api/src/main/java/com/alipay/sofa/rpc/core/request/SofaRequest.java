/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.rpc.core.request;

import com.alipay.sofa.rpc.common.RpcConstants;
import com.alipay.sofa.rpc.core.invoke.SofaResponseCallback;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Based on RequestBase, add some extensional properties, such as requestProps
 * <p>
 * INFO: this object will create in every RPC request
 *
 * @author <a href=mailto:hongwei.yhw@antfin.com>HongWei Yi</a>
 */
public class SofaRequest extends RequestBase {

    private static final long   serialVersionUID = 7329530374415722876L;

    /**
     * 对方应用名称：例如`A进程`调`B进程`(B里面有B1,B2两个应用)，这里传递的是B1。
     */
    private String              targetAppName;

    /**
     * 扩展属性 extensional properties
     */
    private Map<String, Object> requestProps;

    /**
     * Gets request prop.
     *
     * @param key the key
     * @return request prop
     */
    public Object getRequestProp(String key) {
        return requestProps != null ? requestProps.get(key) : null;
    }

    /**
     * Add request prop.
     *
     * @param key   the key
     * @param value the value
     */
    public void addRequestProp(String key, Object value) {
        if (key == null || value == null) {
            return;
        }
        if (requestProps == null) {
            requestProps = new HashMap<String, Object>();
        }
        requestProps.put(key, value);
    }

    /**
     * Remove request prop.
     *
     * @param key the key
     */
    public void removeRequestProp(String key) {
        if (key == null) {
            return;
        }
        if (requestProps != null) {
            requestProps.remove(key);
        }
    }

    /**
     * Add request props.
     *
     * @param map the map
     */
    public void addRequestProps(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        if (requestProps == null) {
            requestProps = new HashMap<String, Object>();
        }
        requestProps.putAll(map);
    }

    /**
     * Gets request props.
     *
     * @return the request props
     */
    public Map<String, Object> getRequestProps() {
        return requestProps;
    }

    /**
     * Gets target app name.
     *
     * @return the target app name
     */
    public String getTargetAppName() {
        return targetAppName;
    }

    /**
     * Sets target app name.
     *
     * @param targetAppName the target app name
     */
    public void setTargetAppName(String targetAppName) {
        this.targetAppName = targetAppName;
    }

    //====================== 下面是非传递属性 ===============
    /**
     * 方法对象(缓存一些，减少反射，服务端使用）
     */
    private transient Method               method;

    /**
     * 接口名
     */
    private transient String               interfaceName;

    /**
     * 序列化工厂类型：决定是否泛化调用（客户端使用）
     */
    private transient int                  serializeFactoryType;

    /**
     * 序列化类型（客户端使用）
     */
    private transient byte                 serializeType;

    /**
     * 调用类型（客户端使用）
     */
    private transient String               invokeType;
    /**
     * 用户层服务回调类，调用级别（客户端使用）
     */
    private transient SofaResponseCallback sofaResponseCallback;

    /**
     * 用户层请求超时，调用级别（客户端使用）
     */
    private transient Integer              timeout;

    /**
     * Gets method.
     *
     * @return the method
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Sets method.
     *
     * @param method the method
     */
    public void setMethod(Method method) {
        this.method = method;
    }

    /**
     * Gets serialize factory type.
     *
     * @return the serialize factory type
     */
    public int getSerializeFactoryType() {
        return serializeFactoryType;
    }

    /**
     * Sets serialize factory type.
     *
     * @param serializeFactoryType the serialize factory type
     * @return the serialize factory type
     */
    public SofaRequest setSerializeFactoryType(int serializeFactoryType) {
        this.serializeFactoryType = serializeFactoryType;
        return this;
    }

    /**
     * Gets serialize type.
     *
     * @return the serialize type
     */
    public byte getSerializeType() {
        return serializeType;
    }

    /**
     * Sets serialize type.
     *
     * @param serializeType the serialize type
     * @return the serialize type
     */
    public SofaRequest setSerializeType(byte serializeType) {
        this.serializeType = serializeType;
        return this;
    }

    /**
     * Gets invoke type.
     *
     * @return the invoke type
     */
    public String getInvokeType() {
        return invokeType;
    }

    /**
     * Sets invoke type.
     *
     * @param invokeType the invoke type
     * @return the invoke type
     */
    public SofaRequest setInvokeType(String invokeType) {
        this.invokeType = invokeType;
        return this;
    }

    /**
     * Gets interface name.
     *
     * @return the interface name
     */
    public String getInterfaceName() {
        return interfaceName;
    }

    /**
     * Sets interface name.
     *
     * @param interfaceName the interface name
     */
    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    /**
     * Gets sofa response callback.
     *
     * @return the sofa response callback
     */
    public SofaResponseCallback getSofaResponseCallback() {
        return sofaResponseCallback;
    }

    /**
     * Sets sofa response callback.
     *
     * @param sofaResponseCallback the sofa response callback
     * @return the sofa response callback
     */
    public SofaRequest setSofaResponseCallback(SofaResponseCallback sofaResponseCallback) {
        this.sofaResponseCallback = sofaResponseCallback;
        return this;
    }

    /**
     * Gets timeout.
     *
     * @return the timeout
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Sets timeout.
     *
     * @param timeout the timeout
     * @return the timeout
     */
    public SofaRequest setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * 是否异步请求
     *
     * @return 如果是Future和Callback，是异步请求
     */
    public boolean isAsync() {
        return invokeType != null && (RpcConstants.INVOKER_TYPE_CALLBACK.equals(invokeType)
            || RpcConstants.INVOKER_TYPE_FUTURE.equals(invokeType));

    }
}
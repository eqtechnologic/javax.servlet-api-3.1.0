/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 *
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jakarta.servlet.http;

/**
 *
 * Events of this type are either sent to an object that implements
 * {@link HttpSessionBindingListener} when it is bound or unbound from a
 * session, or to a {@link HttpSessionAttributeListener} that has been
 * configured in the deployment descriptor when any attribute is bound, unbound
 * or replaced in a session.
 *
 * <p>The session binds the object by a call to
 * <code>HttpSession.setAttribute</code> and unbinds the object
 * by a call to <code>HttpSession.removeAttribute</code>.
 *
 * @author Various
 * 
 * @see HttpSession
 * @see HttpSessionBindingListener
 * @see HttpSessionAttributeListener
 */

public class HttpSessionBindingEvent extends HttpSessionEvent {

    private static final long serialVersionUID = 7308000419984825907L;

    /* The name to which the object is being bound or unbound */
    private String name;
    
    /* The object is being bound or unbound */
    private Object value;
    
    /**
     *
     * Constructs an event that notifies an object that it
     * has been bound to or unbound from a session. 
     * To receive the event, the object must implement
     * {@link HttpSessionBindingListener}.
     *
     * @param session the session to which the object is bound or unbound
     * @param name the name with which the object is bound or unbound
     *
     * @see #getName
     * @see #getSession
     */
    public HttpSessionBindingEvent(HttpSession session, String name) {
        super(session);
        this.name = name;
    }
    
    /**
     *
     * Constructs an event that notifies an object that it
     * has been bound to or unbound from a session. 
     * To receive the event, the object must implement
     * {@link HttpSessionBindingListener}.
     *
     * @param session the session to which the object is bound or unbound
     * @param name the name with which the object is bound or unbound
     *
     * @see #getName
     * @see #getSession
     */
    public HttpSessionBindingEvent(HttpSession session, String name, Object value) {
        super(session);
        this.name = name;
        this.value = value;
    }
    
    /** Return the session that changed. */
    @Override
    public HttpSession getSession () { 
        return super.getSession();
    }
 
    /**
     * Returns the name with which the attribute is bound to or
     * unbound from the session.
     *
     * @return a string specifying the name with which
     *         the object is bound to or unbound from the session
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the value of the attribute that has been added, removed or
     * replaced. If the attribute was added (or bound), this is the value of the
     * attribute. If the attribute was removed (or unbound), this is the value
     * of the removed attribute. If the attribute was replaced, this is the old
     * value of the attribute.
     *
     * @since Servlet 2.3
     */
    public Object getValue() {
        return this.value;   
    }
}

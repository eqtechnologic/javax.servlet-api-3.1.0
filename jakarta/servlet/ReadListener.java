/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011-2013 Oracle and/or its affiliates. All rights reserved.
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
 */


package jakarta.servlet;

import java.io.IOException;
import java.util.EventListener;

/**
 * <p>
 * This class represents a call-back mechanism that will notify implementations
 * as HTTP request data becomes available to be read without blocking.
 * </p>
 *
 * @since Servlet 3.1
 */
public interface ReadListener extends EventListener {

    /**
     * When an instance of the <code>ReadListener</code> is registered with a {@link ServletInputStream},
     * this method will be invoked by the container the first time when it is possible
     * to read data. Subsequently the container will invoke this method if and only
     * if {@link jakarta.servlet.ServletInputStream#isReady()} method
     * has been called and has returned <code>false</code>.
     *
     * @throws IOException if an I/O related error has occurred during processing
     */
    public void onDataAvailable() throws IOException;

    /**
     * Invoked when all data for the current request has been read.
     *
     * @throws IOException if an I/O related error has occurred during processing
     */

    public void onAllDataRead() throws IOException;

    /**
     * Invoked when an error occurs processing the request.
     */
    public void onError(Throwable t);


}

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tamaya.integration.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test using standard Spring setup.
 */
public class SpringConfigTest2 {

    @Test
    public void assertDefaultSetup(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config-scanOnly.xml");
        ConfiguredSpringBean configuredBean = context.getBean(ConfiguredSpringBean.class);
        assertNotNull(configuredBean.getJavaVersion());
        assertEquals(System.getProperty("java.version"), configuredBean.getJavaVersion());
        org.springframework.core.env.Environment env;
        assertNotNull(configuredBean.getMessage());
        assertEquals("value2", configuredBean.getMessage());
    }

}

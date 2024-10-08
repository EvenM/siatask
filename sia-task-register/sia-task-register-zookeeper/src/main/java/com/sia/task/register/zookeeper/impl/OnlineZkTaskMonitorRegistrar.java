/*-
 * <<
 * task
 * ==
 * Copyright (C) 2019 - 2020 sia
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package com.sia.task.register.zookeeper.impl;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @author maozhengwei
 * @version V1.0.0
 * @description
 * @data 2019-10-24 16:11
 * @see
 **/
public class OnlineZkTaskMonitorRegistrar implements ImportBeanDefinitionRegistrar {


    private static final String siaTaskZkMonitorRegister = "com.sia.task.scheduler.annotations.EnableSiaTaskScheduler";

    /**
     * Register bean definitions as necessary based on the given annotation metadata of
     * the importing {@code @Configuration} class.
     * <p>Note that {@link BeanDefinitionRegistryPostProcessor} types may <em>not</em> be
     * registered here, due to lifecycle constraints related to {@code @Configuration}
     * class processing.
     *
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry               current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Set<String> metaAnnotationTypes = importingClassMetadata.getAnnotationTypes();
        if (metaAnnotationTypes.contains(siaTaskZkMonitorRegister)) {
            registry.registerBeanDefinition(ModifyOnlineJobStatusByZookeeperImpl.class.getName(), new RootBeanDefinition(ModifyOnlineJobStatusByZookeeperImpl.class));
        }
    }
}

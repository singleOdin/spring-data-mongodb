/*
 * Copyright 2014-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import example.Comment;
import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Unit test for {@link ConfigClassInDefaultPackage}.
 *
 * @author Oliver Gierke
 */
public class ConfigClassInDefaultPackageUnitTests {

	@Resource
	private MongoTemplate mongoTemplate;

	@Test // DATAMONGO-877
	public void loadsConfigClassFromDefaultPackage() {
		new AnnotationConfigApplicationContext(ConfigClassInDefaultPackage.class).close();
	}

	@Test
	public void test1() {
//		mongoTemplate.updateFirst();
		List<Comment> all = mongoTemplate.findAll(Comment.class, mongoTemplate.getCollectionName(Comment.class));

		System.out.println(all);
	}
}

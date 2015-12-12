package org.rapidoid.web;

import java.util.Collections;

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.config.Conf;
import org.rapidoid.config.Config;
import org.rapidoid.ctx.Classes;
import org.rapidoid.http.fast.FastHttp;
import org.rapidoid.http.fast.On;
import org.rapidoid.http.fast.handler.FastHttpHandler;
import org.rapidoid.scan.Scan;
import org.rapidoid.u.U;

/*
 * #%L
 * rapidoid-web
 * %%
 * Copyright (C) 2014 - 2015 Nikolche Mihajlovski and contributors
 * %%
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
 * #L%
 */

@Authors("Nikolche Mihajlovski")
@Since("4.1.0")
public class RootWebApp extends WebApp {

	@SuppressWarnings("unchecked")
	public RootWebApp() {
		super("root", Collections.EMPTY_SET, Collections.EMPTY_SET, U.set("/"), Conf.dev() ? AppMode.DEVELOPMENT
				: AppMode.PRODUCTION, null, Classes.from(Scan.getClasses()), new Config(Conf.root().toMap()), handler());
	}

	private static FastHttpHandler handler() {
		FastHttp http = On.getDefaultSetup().http();
		return new AppHandler(http);
	}

}

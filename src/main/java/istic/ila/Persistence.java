/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package istic.ila;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.KeyFactory;

//[START all]
public class Persistence {

  private static AtomicReference<Datastore> datastore = new AtomicReference<>();

  @SuppressWarnings("JavadocMethod")
  public static Datastore getDatastore() {
    if (datastore.get() == null) {
    	
    	// on definit le projet-id cible depuis un fichier de properties
		/*Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("values.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String projetId = properties.getProperty("projet.id");
		datastore.set(
          DatastoreOptions.newBuilder().setProjectId(projetId).build().getService());
    */
    	datastore.set(
    	          DatastoreOptions.newBuilder().setProjectId("tlc-projet").build().getService());

    }

    return datastore.get();
  }

  public static void setDatastore(Datastore datastore) {
    Persistence.datastore.set(datastore);
  }

  public static KeyFactory getKeyFactory(Class<?> c) {
    return getDatastore().newKeyFactory().setKind(c.getSimpleName());
  }
}
//[END all]

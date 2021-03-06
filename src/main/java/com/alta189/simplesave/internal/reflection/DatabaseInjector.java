/*
 * This file is part of SimpleSave
 *
 * SimpleSave is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SimpleSave is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.alta189.simplesave.internal.reflection;

import com.alta189.simplesave.Configuration;
import com.alta189.simplesave.Database;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DatabaseInjector {
	public static Database newInstance(Class<?> clazz, Configuration config) {
		try {
			Constructor<?> constructor = clazz.getConstructor(Configuration.class);
			return (Database) constructor.newInstance(config);
		} catch (NoSuchMethodException e) {
			throw new InjectorException("Could not create a new instance of class '" + clazz.getCanonicalName() + "'", e.getCause());
		} catch (InvocationTargetException e) {
			throw new InjectorException("Could not create a new instance of class '" + clazz.getCanonicalName() + "'", e.getCause());
		} catch (InstantiationException e) {
			throw new InjectorException("Could not create a new instance of class '" + clazz.getCanonicalName() + "'", e.getCause());
		} catch (IllegalAccessException e) {
			throw new InjectorException("Could not create a new instance of class '" + clazz.getCanonicalName() + "'", e.getCause());
		} catch (ClassCastException e) {
			throw new InjectorException("Could not create a new instance of class '" + clazz.getCanonicalName() + "'", e.getCause());
		}
	}
}

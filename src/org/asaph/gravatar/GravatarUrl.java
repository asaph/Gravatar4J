/*
 * Copyright 2009 asaph.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.asaph.gravatar;

import java.io.Serializable;

/**
 * A class for building Gravatar URLs based on the <a href="http://gravatar.com/site/implement/url" target="_top">Gravatar implementation guide</a>.
 * 
 * <p>Sample usage: The following code prints out the URL to the Gravatar image based on the supplied email address:
 * 
 * <blockquote><pre><code>GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com");
 *System.out.println(gravatarUrl);</code></pre></blockquote>
 * 
 * The above code outputs:
 * 
 * <blockquote><pre><code>http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg</code></pre></blockquote>
 * 
 * The optional size, rating and default icon settings are also supported. Constants for rating and default icon are provided for convenience.
 * 
 * <blockquote><pre><code>GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com", 512, GravatarUrl.Rating.PG, GravatarUrl.DEFAULT_ICON_IDENTICON);
 *System.out.println(gravatarUrl);</code></pre></blockquote>
 *
 * The above code outputs:
 * 
 * <blockquote><pre><code>http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?s=512&amp;r=pg&amp;d=identicon</code></pre></blockquote>
 * 
 * @author asaph
 */
public class GravatarUrl implements Serializable {
	/**
	 * Prefix for all Gravatar URLs (http://www.gravatar.com/avatar/)
	 */
	public final static String GRAVATAR_URL_PREFIX = "http://www.gravatar.com/avatar/";
	/**
	 * <a href="http://scott.sherrillmix.com/blog/blogger/wp_identicon/" target="_top">Identicon</a> avatar theme by <a href="http://scott.sherrillmix.com/" target="_top">Scott Sherrill-Mix</a>
	 */
	public final static String DEFAULT_ICON_IDENTICON = "identicon";
	/**
	 * <a href="http://scott.sherrillmix.com/blog/blogger/wp_monsterid/" target="_top">MonsterID</a> avatar theme by <a href="http://scott.sherrillmix.com/" target="_top">Scott Sherrill-Mix</a>
	 */
	public final static String DEFAULT_ICON_MONSTERID = "monsterid";
	/**
	 * <a href="http://www.shamusyoung.com/twentysidedtale/?p=1462" target="_top">Wavatar</a> avatar theme by <a href="http://www.shamusyoung.com/" target="_top">Shamus Young</a>
	 */
	public final static String DEFAULT_ICON_WAVATAR = "wavatar";
	/**
	 * Theme not found
	 */
	public final static String DEFAULT_ICON_NOT_FOUND = "404";
	
	/**
	 * Enumeration containing all possible values for Gravatar ratings. Specifically: <code>g</code>, <code>pg</code>, <code>r</code> and <code>x</code>.
	 * 
	 * @author asaph
	 *
	 */
	public static enum Rating {
		/**
		 * General Audiences
		 */
		G("g"),
		/**
		 * Parental Guidance Suggested
		 */
		PG("pg"),
		/**
		 * Restricted
		 */
		R("r"),
		/**
		 * May contain adult content
		 */
		X("x");
		
		private String queryStringVariableName;
		
		/**
		 * Constructor for building an enum value.
		 * 
		 * @param queryStringVariableName
		 */
		private Rating(String queryStringVariableName) {
			this.queryStringVariableName = queryStringVariableName;
		}
		
		/**
		 * Get a string representation of this rating
		 * 
		 * @return a string represenation of this rating
		 */
		@Override
		public String toString() {
			return this.queryStringVariableName;
		}
	}
	
	protected String email;
	protected int size;
	protected Rating rating;
	protected String defaultIcon;
	
	/**
	 * Constructor for building a GravatarUrl object while specifying all possible parameters.
	 * 
	 * @param email The email address linked to the user's Gravatar account
	 * @param size The size in pixels. This value must be between 1 and 512 inclusive.
	 * @param rating The rating. Can be one of <code>g</code>, <code>pg</code>, <code>r</code> or <code>x</code>.
	 * @param defaultIcon The icon scheme to use if no match for the email address is found. eg. identicon, monsterid, wavatar, 404.
	 */
	public GravatarUrl(String email, int size, Rating rating, String defaultIcon) {
		this.email = email;
		this.size = size;
		this.rating = rating;
		this.defaultIcon = defaultIcon;
	}
	
	/**
	 * Constructor for building a GravatarUrl object using just email address. Defaults are used for all other values.
	 * 
	 * @param email The email address linked to the user's Gravatar account
	 */
	public GravatarUrl(String email) {
		this(email, 0, null, null);
	}

	/**
	 * Get the email address for this GravatarUrl instance
	 * 
	 * @return The email address linked to the user's Gravatar account
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email address for this GravatarUrl instance
	 * 
	 * @param email The email address linked to the user's Gravatar account
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the size in pixels for this GravatarUrl instance
	 * 
	 * @return The size in pixels. This value must be between 1 and 512 inclusive.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Set the size in pixels for this GravatarUrl instance
	 *
	 * @param size The size in pixels. This value must be between 1 and 512 inclusive.
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Get the rating associated with this GravatarUrl instance.
	 * 
	 * @return The rating. Can be one of <code>g</code>, <code>pg</code>, <code>r</code> or <code>x</code>.
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * Set the rating associated with this GravatarUrl instance.
	 * 
	 * @param rating The rating. Can be one of <code>g</code>, <code>pg</code>, <code>r</code> or <code>x</code>.
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}

	/**
	 * Get the default icon scheme for thie GravatarUrl instance.
	 * 
	 * @return The icon scheme to use if no match for the email address is found. eg. identicon, monsterid, wavatar, 404.
	 */
	public String getDefaultIcon() {
		return defaultIcon;
	}

	/**
	 * Set the default icon scheme for thie GravatarUrl instance.
	 * 
	 * @param defaultIcon The icon scheme to use if no match for the email address is found. eg. identicon, monsterid, wavatar, 404.
	 */
	public void setDefaultIcon(String defaultIcon) {
		this.defaultIcon = defaultIcon;
	}	
	
	/**
	 * Get a url to the gravatar image.
	 * 
	 * @return the gravatar url
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder url = new StringBuilder(GravatarUrl.GRAVATAR_URL_PREFIX);
		url.append(EncodingHelper.md5Hex(this.email.toLowerCase()));
		url.append(".jpg");
		
		String queryString = this.getQueryString();
		if (queryString.length() > 0) {
			url.append('?');
			url.append(queryString);
		}
		return url.toString();
	}

	/**
	 * Format the parameters for this gravatar url as a querystring
	 * 
	 * @return the querystring portion of the gravatar url represented by this instance
	 */
	protected String getQueryString() {
		StringBuilder queryString = new StringBuilder();
		if (this.size > 0) {
			queryString.append("s=");
			queryString.append(Integer.toString(this.size));
		}
		if (this.rating != null) {
			if (queryString.length() > 0) {
				queryString.append('&');
			}
			queryString.append("r=");
			queryString.append(this.rating);
		}
		if (this.defaultIcon != null) {
			if (queryString.length() > 0) {
				queryString.append('&');
			}
			queryString.append("d=");
			queryString.append(EncodingHelper.urlEncode(this.defaultIcon));
		}
		return queryString.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((defaultIcon == null) ? 0 : defaultIcon.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + size;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GravatarUrl)) {
			return false;
		}
		GravatarUrl other = (GravatarUrl) obj;
		if (defaultIcon == null) {
			if (other.defaultIcon != null) {
				return false;
			}
		} else if (!defaultIcon.equals(other.defaultIcon)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (rating == null) {
			if (other.rating != null) {
				return false;
			}
		} else if (!rating.equals(other.rating)) {
			return false;
		}
		if (size != other.size) {
			return false;
		}
		return true;
	}
}

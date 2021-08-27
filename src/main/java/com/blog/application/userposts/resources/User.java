package com.blog.application.userposts.resources;

public class User {
	
	private Integer id;
	private String name;
	private String username;
	private String email;
	private Address address;	
	private String phone;
	private String website;
	private Company company;
			
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer id, String name, String username, String email, Address address, String phone, String website,
			Company company) {
		
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	public class Address {
		private String street;
		private String suite;		
		private String city;
		private String zipcode;
		private Geography geo;
		
		public Address() {
			// TODO Auto-generated constructor stub
		}
		
		
		public Address(String street, String suite, String city, String zipcode, Geography geo) {
			super();
			this.street = street;
			this.suite = suite;
			this.city = city;
			this.zipcode = zipcode;
			this.geo = geo;
		}


		public String getStreet() {
			return street;
		}


		public void setStreet(String street) {
			this.street = street;
		}


		public String getSuite() {
			return suite;
		}


		public void setSuite(String suite) {
			this.suite = suite;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getZipcode() {
			return zipcode;
		}


		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}


		public Geography getGeo() {
			return geo;
		}


		public void setGeo(Geography geo) {
			this.geo = geo;
		}


		public class Geography {
			private String lat;
			private String lng;
			
			public Geography() {
				// TODO Auto-generated constructor stub
			}
			
			public Geography(String lat, String lng) {
				this.lat = lat;
				this.lng = lng;
			}

			public String getLat() {
				return lat;
			}

			public void setLat(String lat) {
				this.lat = lat;
			}

			public String getLng() {
				return lng;
			}

			public void setLng(String lng) {
				this.lng = lng;
			}
						
		}
	}
	
	public class Company {
		private String name;
		private String catchPhrase;
		private String bs;
		
		public Company() {
			// TODO Auto-generated constructor stub
		}
		
		public Company(String name, String catchPhrase, String bs) {
			super();
			this.name = name;
			this.catchPhrase = catchPhrase;
			this.bs = bs;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getCatchPhrase() {
			return catchPhrase;
		}
		
		public void setCatchPhrase(String catchPhrase) {
			this.catchPhrase = catchPhrase;
		}
		
		public String getBs() {
			return bs;
		}
		
		public void setBs(String bs) {
			this.bs = bs;
		}				
	}
}
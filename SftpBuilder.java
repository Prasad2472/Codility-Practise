/**
 * 
 */
package com.filehub.filedownload;

/**
 * @author Prasad
 *
 */
public class SftpBuilder {

	private String userName;
	private String pwd;
	private String host;
	private int port;

	public SftpBuilder setUserName(final String userName) {
		this.userName = userName;
		return this;
	}

	public SftpBuilder setPwd(final String pwd) {
		this.pwd = pwd;
		return this;
	}

	public SftpBuilder setHost(final String host) {
		this.host = host;
		return this;
	}

	public SftpBuilder setPort(final int port) {
		this.port = port;
		return this;
	}

	public SftpConnector getSftpUtil() {

		return new SftpConnector(this.userName, this.pwd, this.host, this.port);
	}
}

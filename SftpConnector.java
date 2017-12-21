/**
 * 
 */
package com.filehub.filedownload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * @author Prasad
 *
 */
public class SftpConnector {
	private Session session;

	public SftpConnector(final String userName, final String pwd, final String host,
			final int port) {

		createSession(userName, pwd, host, port);
	}

	private void createSession(final String userName, final String pwd,
			final String host, final int port) {
		final JSch jSch = new JSch();
		try {
			session = jSch.getSession(userName, host, port);
			session.setPassword(pwd);
			// Setting the configuration specific properties
			final Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			config.put("PreferredAuthentications",
					"publickey,keyboard-interactive,password");
			session.setConfig(config);
		} catch (final JSchException e) {
			e.printStackTrace();
		}
	}

	public void downloadFile(final String channelName,
			final String remoteDirectory, final String remoteFileName,
			final String localDirectory, final String localFileName) {
		Channel channel = null;
		ChannelSftp channelSftp = null;
		try {
			connect();
			// Setting the channel type as sftp
			channel = session.openChannel(channelName);
			// Establishing the connection
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			// Setting the folder location of the external system as configured
			channelSftp.cd(remoteDirectory);
			final FileOutputStream fileOutputStream = new FileOutputStream(
					localDirectory
							+ ((localFileName == null || ""
									.equals(localFileName)) ? remoteFileName
									: localFileName));
			final BufferedOutputStream stream = new BufferedOutputStream(
					fileOutputStream);
			System.err.println("Source Directory-->" + channelSftp.pwd());
			System.err.println("Source Directory-LPD->" + channelSftp.lpwd());
			channelSftp.get(remoteFileName, stream);
			stream.close();
			fileOutputStream.close();
			System.out.println("Download Comnpleted....!");
		} catch (final JSchException e) {
			e.printStackTrace();
		} catch (final SftpException e) {
			e.printStackTrace();
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			// Validating if channel sftp is not null to exit
			if (channelSftp != null) {
				channelSftp.exit();
			}
			// Validating if channel is not null to disconnect
			if (channel != null) {
				channel.disconnect();
			}
			// Validating if session instance is not null to disconnect
			if (session != null) {
				session.disconnect();
			}
		}

	}

	public void uploadFile(final String channelName, final String fileName,
			final String uploadDirectory) {
		Channel channel = null;
		ChannelSftp channelSftp = null;
		try {
			connect();
			// Setting the channel type as sftp
			channel = session.openChannel(channelName);
			// Establishing the connection
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			// Setting the folder location of the external system as configured
			channelSftp.cd(uploadDirectory);
			// Uploading File..
			System.out.println("File Upload is Stating....");
			// Creating the file instance
			final File file = new File(fileName);
			// Creating an fileInputStream instance
			final FileInputStream inputStream = new FileInputStream(file);
			final BufferedInputStream bufferedInputStream = new BufferedInputStream(
					inputStream);
			channelSftp.put(bufferedInputStream, file.getName());
			System.out.println("File Upload is Completed....");
			bufferedInputStream.close();
			inputStream.close();
		} catch (final JSchException e) {
			e.printStackTrace();
		} catch (final SftpException e) {
			e.printStackTrace();
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Validating if channel sftp is not null to exit
			if (channelSftp != null) {
				channelSftp.exit();
			}
			// Validating if channel is not null to disconnect
			if (channel != null) {
				channel.disconnect();
			}
			// Validating if session instance is not null to disconnect
			if (session != null) {
				session.disconnect();
			}
		}
	}

	private void connect() throws JSchException {
		// Execution start time
		final long lStartTime = System.currentTimeMillis();
		System.out.println("Connecting to the sftp...");
		// Connecting to the sftp
		session.connect();
		System.out.println("Connected to the sftp.");
		// Execution end time
		final long lEndTime = System.currentTimeMillis();
		System.out.println("---------------------------------------------");
		System.out.println("Connected to SFTP in : "
				+ (lEndTime - lStartTime));
	}
}

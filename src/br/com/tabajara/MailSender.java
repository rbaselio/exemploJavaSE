package br.com.tabajara;

import java.util.ArrayList;
import java.util.List;

public class MailSender implements Runnable {

	private List<String> mailAddresses = new ArrayList<>();

	public void send(String mailAddress) {
		this.mailAddresses.add(mailAddress);
		Thread thread = new Thread(this, mailAddress);
		thread.start();
		
	}

	@Override
	public void run() {
		try {
			synchronized (this) {
				if (!this.mailAddresses.isEmpty()) {
					int ultimo = this.mailAddresses.size() - 1;
					Thread.sleep(1000);

					System.out.println("Inicio: "
							+ this.mailAddresses.get(ultimo).toUpperCase());

					this.mailAddresses.remove(ultimo);
				}
			}
			System.out.println("Conectando no SMTP");
			Thread.sleep(2000);
			System.out.println("Autenticando");
			Thread.sleep(2000);
			System.out.println("Tentando enviar");
			Thread.sleep(2000);
			System.out.println("Enviando");
			Thread.sleep(2000);
			System.out.println("Concluido!");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
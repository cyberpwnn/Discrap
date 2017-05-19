package org.cyberpwn.discrap;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.EventListener;

public class Discrap implements EventListener
{
	private static JDA jda;
	
	public static void main(String[] args)
	{
		try
		{
			jda = new JDABuilder(AccountType.BOT).setToken("MzAwNDYwNTQ0MDczMTM4MTc2.C8sxSA.8YiApODqzHMAN2u79CyxO0chRUc").buildBlocking();
			jda.setAutoReconnect(true);
			jda.addEventListener(new Discrap());
		}
		
		catch(LoginException e)
		{
			e.printStackTrace();
		}
		
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		catch(RateLimitedException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onEvent(Event event)
	{
		if(event instanceof MessageReceivedEvent)
		{
			MessageReceivedEvent e = (MessageReceivedEvent) event;
			
			if(e.getMessage().getStrippedContent().equalsIgnoreCase(";test"))
			{
				e.getAuthor().getPrivateChannel().sendMessage(new MessageBuilder().append("Test Succeeded").setTTS(true).build());
			}
		}
	}
}

package br.com.toshiaki.strconsumer.listeners;


import br.com.toshiaki.strconsumer.listeners.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {


  @StrConsumerCustomListener(groupId = "group-1")
  public void create(String message)  {
    log.info("CREATE ::: Receive message {}", message);
    throw new IllegalArgumentException("EXEPTION....");
  }

  @StrConsumerCustomListener(groupId = "group-1")
  public void log(String message) {
    log.info("LOG ::: Receive message {}", message);
  }

  @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
  public void history(String message) {
    log.info("HISTORY ::: Receive message {}", message);
  }
}

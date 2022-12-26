package br.com.toshiaki.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {
  @KafkaListener(groupId ="group-1",topics = "str-topic", containerFactory = "strContainerFactory")
public void listener(final String message){
  log.info("Receive message {}",message);
}
}

package com.training.services.voyage;

import lombok.Getter;
import java.util.List;

@Getter
public class Payload {
   private List<Voyages> voyages;
   private String currentSailDate;
}
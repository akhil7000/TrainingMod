package com.training.services.voyage;

import lombok.Getter;
import java.util.List;

@Getter
public class Payload {
   List<Voyages> voyages;
   String currentSailDate;
}
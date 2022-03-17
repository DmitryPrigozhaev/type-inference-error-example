package com.prigozhaev.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * A POJO used to match some incoming JSON.
 *
 * @author Dmitry Prigozhaev
 * on 17.03.2022
 */
@Getter
@ToString
@EqualsAndHashCode
public class OutputObject {

  private final Long id;
  private final String description;

  /**
   * The default class constructor.
   *
   * @param id          the ID as {@link Long} object
   * @param description the description as {@link String} object
   */
  public OutputObject(Long id, String description) {
    this.id = id;
    this.description = description;
  }
}

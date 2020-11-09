package ru.netology.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AfishaMovieItem {
  private int id;
  private int filmId;
  private String filmName;
  private String genre;
  private boolean date;
}
#!/usr/bin/env python3

import random

def dynamic_file_maker(name, num_particles, matrix_length):
  dynamic_file = open(name, 'w')
  dynamic_file.write(str(num_particles) + '\n' + '\n')
  for i in range(1, num_particles + 1):
    dynamic_file.write(str(random.uniform(0, matrix_length)) + '  ' + str(random.uniform(0, matrix_length)) + '\n')
  return

def static_file_maker(name, num_particles, length, radius, prop):
  static_file = open(name, 'w')
  static_file.write(str(num_particles) + '\n' + str(length) + '\n')
  for i in range(1, num_particles + 1):
    static_file.write(str(radius) + ' ' + str(prop) + '\n')
  return

def generate_all_files(length, particles, radius, prop):
  static_file_maker('s.txt', particles, length, radius, prop)
  dynamic_file_maker('d.txt', particles, length)
  return

length = input("Insert area length:\n")
radius = input("Insert particle radius:\n")
try:
  length_int = int(length)
  radius_float = float(radius)
  num_particles = input("Insert number of particles:\n")
  try:
    part_int = int(num_particles)
    generate_all_files(length_int, part_int, radius_float, 1.0)
  except ValueError:
    print("Invalid input")
except ValueError:
    print("Invalid input")
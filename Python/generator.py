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

def generate_all_files(matrix_size, length, radius, prop):
  for i in range(1, 11):
    static_file_maker('Static' + str(i*10), i*10, length, radius, prop)
    static_file_maker('Static' + str(i*100), i*100, length, radius, prop)
    dynamic_file_maker('Dynamic' + str(i*10), i*10, matrix_size*length)
    dynamic_file_maker('Dynamic' + str(i*100), i*100, matrix_size*length)
  return


generate_all_files(20, 20, 1, 0)

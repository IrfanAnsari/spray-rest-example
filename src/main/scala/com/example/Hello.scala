package com.example

import spray.http.{StatusCodes, HttpResponse}

object Hello {
  def main(args: Array[String]) = {
    HttpResponse(status = StatusCodes.OK)
  }
}

package com.aal.routes

import org.specs2.mutable.Specification
import spray.http.HttpResponse
import spray.routing.Directives
import spray.testkit.Specs2RouteTest


abstract class RoutingSpec extends Specification with Directives with Specs2RouteTest {

  val Ok = HttpResponse()
  val completeOk = complete(Ok)

}

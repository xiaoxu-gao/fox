/*
 *  @author Sara Magliacane
 *  @author Philip Stutz
 *
 *  Copyright 2013-2015 University of Zurich & VU University Amsterdam
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.signalcollect.psl.model

object DistanceMeasure {
  val defaultMeasure: DistanceMeasure = Squared
  val validMeasures = Set(Linear, Squared)
  def parse(s: String): DistanceMeasure = {
    val lower = s.toLowerCase
    lower match {
      case Linear(_) => Linear
      case Squared(_) => Squared
      case other => throw new Exception(
        s"Could not parse distance measure $other, valid measures are:\n" +
          validMeasures.mkString(", "))
    }
  }
}

sealed trait DistanceMeasure {
  def unapply(s: String): Option[DistanceMeasure] = if (s == toString) Some(this) else None
}

case object Linear extends DistanceMeasure {
  override val toString = "linear"
}

case object Squared extends DistanceMeasure {
  override val toString = "squared"
}


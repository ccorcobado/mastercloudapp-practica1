# mastercloudapp-practica1
Practica 1 - Diseño y calidad

## MasterMind UML

### svg 
<p align="center">
  <img alt="" src="https://www.plantuml.com/plantuml/img/VLH1QiCm4Bph5NjqYfqNb9BIQmkXEVIyiHOZa2KZoPZGzkzTIuaj9QOtx-piQ7OaVF01NHXxBKIhqNluG1_8zSh8Rm63nakr0n2_j_Q9MaVXo3Wv9XHrTNHsi9vaAdSyxsX0Hr4208sVcCKuJ4u5XbatoPQJip26GFqGF7yEgHa7EmhlxB3ahvAlSSglm8tuPlkpCXYKDLdta_oeGwoL_rB6NBMKVxSybOhMcg3CIFDPodJLgKKJjuCbbKnTa1bx1hHrCEy1u4ZMSDOZrN0XhUrKG-U8J0tMeUaO7aOtQ5h2I9bccclG6PYyeMv7ZSic6-lcSS-Moy3lJd64SbaQ5MSLDs6BrgkRMjcR4K-XIWuUebmoIltv4Cc7pFSgiSUEPE7lVbQixn6UckQbU70FpV9P296JOOjGrc1pJdwfXP1TVUGSyG31Vl-Vt3qp9IHoE6uLOnO5_lpJI3kPPiF69ctBXDW0qsvN8q8So4Z-D_m1">
</p>

### PlantUML
 
 ```PlantUML
 @startuml

class Mastermind{
 play()  
}

class SecretPlayer{
  SecretPlayer(ProposedPlayer)
 prepare()  
  answer()
  write()
}
class ProposedPlayer{
  attempts
  propose()
  getLastProposedPlayer()
  writeAttemps()
  writeProposedCombinations()
  writeResult()
  isWinner()
  isLooser()
  continuePlaying(Scaner)
  }

class Combination
enum Color {
    red, blue, yellow, green, orange, purple
}
class SecretCombination{
  SecretCombination()
  calculateResult(ProposedCombination)
  write()
  }
class ProposedCombination{
  read()
  contains(Color, position)
  contains(Color)
  set(Result)
  isWinner()
  }

class Result{
  deads
  damaged
  write()
  isWinner()
  }


Mastermind *--> SecretPlayer
Mastermind *--> ProposedPlayer

SecretPlayer --> ProposedPlayer

ProposedPlayer o--> ProposedCombination
SecretPlayer o--> SecretCombination

SecretCombination ..> ProposedCombination
SecretCombination ..> Result
Combination *--> Color

Combination <|-down- SecretCombination
Combination <|-down- ProposedCombination

ProposedCombination o--> Result


@enduml
 ```
 

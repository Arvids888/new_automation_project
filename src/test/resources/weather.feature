Feature: Testing weather endpoint

  Scenario: Checking weather for city by ID
    Given city ID: 524901
    When we are requesting weather date

    Then coordinates are:
      | lon | 145.77 |
      | lat | -16.92 |

    And weather is:
      | id          | 802              |
      | main        | Clouds           |
      | description | scattered clouds |
      | icon        | 03n              |

    And base is:
      | base | stations |

    And main is:
      | temp     | 300.15 |
      | pressure | 1007   |
      | humidity | 74     |
      | temp_min | 300.15 |
      | temp_max | 300.15 |

    And visibility is:
      | visibility | 10000 |

    And wind is:
      | speed | 3.6 |
      | deg   | 160 |

    And clouds is:
      | clouds | 40 |

    And dt is:
      | dt | 1485790200 |

    And sys is:
      | type    | 1          |
      | id      | 8166       |
      | message | 0.2064     |
      | country | AU         |
      | sunrise | 1485720272 |
      | sunset  | 1485766550 |

    And id is:
      | id | 2172797 |

    And name is:
      | name | Cairns |

    And cod is:
      | cod | 200 |
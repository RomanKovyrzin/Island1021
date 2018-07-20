pragma solidity ^0.4.24;

import "https://github.com/OpenZeppelin/openzeppelin-solidity/contracts/token/ERC20/DetailedERC20.sol";
import "https://github.com/OpenZeppelin/openzeppelin-solidity/contracts/token/ERC20/MintableToken.sol";
import "https://github.com/OpenZeppelin/openzeppelin-solidity/contracts/lifecycle/TokenDestructible.sol";
import "https://github.com/OpenZeppelin/openzeppelin-solidity/contracts/crowdsale/validation/TimedCrowdsale.sol";
import "https://github.com/OpenZeppelin/openzeppelin-solidity/contracts/crowdsale/distribution/RefundableCrowdsale.sol";
import "https://github.com/OpenZeppelin/openzeppelin-solidity/contracts/crowdsale/emission/MintedCrowdsale.sol";

contract CryptEx is DetailedERC20, MintableToken,TokenDestructible {
    constructor() DetailedERC20("Miner", "MNR", 4) public {

    }

    // uint lastMintTime;

    // uint maxMint = 1000000000;
    // uint iteractionCount = 1;

    // function mintStep() external {
    //     if ((now - lastMintTime > 10 minutes ) && (totalSupply() <= maxMint)) {
    //         mint(owner, 1000 / iteractionCount);
    //         lastMintTime = now;
    //         iteractionCount ++;
    //     }
    // }
}

contract SampleCrowdsale is RefundableCrowdsale, MintedCrowdsale {

  constructor(
    //uint256 _openingTime,
    uint256 _closingTime,
    uint256 _rate,
    address _wallet,
    MintableToken _token,
    uint256 _goal
  )
    public
    Crowdsale(_rate, _wallet, _token)
    TimedCrowdsale(block.timestamp, block.timestamp + 1 hours)
    RefundableCrowdsale(_goal)
  {
  }
}

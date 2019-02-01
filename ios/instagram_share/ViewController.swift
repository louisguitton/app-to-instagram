//
//  ViewController.swift
//  instagram_share
//
//  Created by Louis Guitton on 01.02.19.
//  Copyright © 2019 Louis Guitton. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    @IBAction func shareTapped(_ sender: Any?) {
        let url = URL(string: "instagram-stories://share")!
        if UIApplication.shared.canOpenURL(url) {
            let items: [[String: Any]] = [[
            "com.instagram.sharedSticker.backgroundTopColor": "#000000",
            "com.instagram.sharedSticker.backgroundBottomColor": "#FFFFFF",
            "com.instagram.sharedSticker.contentURL": "onefootball"
            ]]
            let options: [UIPasteboard.OptionsKey: Any] = [
                .expirationDate: Date().addingTimeInterval(60 * 5)
            ]
            UIPasteboard.general.setItems(items, options: options)
            UIApplication.shared.open(url, options: [:], completionHandler: nil)
        }
    }
}

